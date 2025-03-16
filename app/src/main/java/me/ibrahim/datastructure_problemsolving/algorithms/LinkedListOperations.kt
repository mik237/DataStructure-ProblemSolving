package me.ibrahim.datastructure_problemsolving.algorithms

import kotlin.math.sin

fun main() {
    val singleLinkedList = SingleLinkedList<String>()
    singleLinkedList.insertAtBeginning("A")
    singleLinkedList.insert("B")
    singleLinkedList.insert("C")
    singleLinkedList.insert("D")
    singleLinkedList.insert("D")
    singleLinkedList.insert("D")
    singleLinkedList.insert("D")
    singleLinkedList.insert("D")
    singleLinkedList.insertAfter("E", "B")
    singleLinkedList.insert("F")
    singleLinkedList.insert("F")
    singleLinkedList.insert("G")
    singleLinkedList.printLinkedList()
//    println(singleLinkedList.search("D"))
//    singleLinkedList.reverseFromToPosition(1, 2)
//    singleLinkedList.removeNthNodeFromEnd(1)
//    singleLinkedList.removeDuplicates()
    singleLinkedList.removeDuplicatesFromSortedLinkedList()
}

data class Node<T>(val data: T?, var next: Node<T>?)

class SingleLinkedList<T> {

    private var head: Node<T>? = null


    //inserting at End by default
    fun insert(data: T) {
        val node = Node(data = data, next = null)
        if (head == null) {
            head = node
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = node
        }
    }

    fun insertAtBeginning(data: T) {
        val node = Node(data, head)
        head = node
    }

    fun insertAfter(data: T, after: T) {
        val node = Node(data, null)
        if (head == null) {
            head = node
        } else {
            var current = head

            while (current != null) {
                if (current.data == after) {
                    node.next = current.next
                    current.next = node
                    break
                }
                current = current.next
            }
        }
    }

    fun deleteFromBeginning() {
        head?.let {
            val tempHead = head
            head = head?.next
            tempHead?.next = null
        }
    }

    //delete from End by default
    fun delete() {
        if (head == null) return
        if (head?.next == null) {
            head = null
            return
        }

        var current = head
        while (current?.next?.next != null) {
            current = current.next
        }
        current?.next = null

    }


    fun search(data: T): Pair<T, Int>? {
        var current = head
        var position = -1
        while (current != null) {
            position += 1
            if (current.data == data) {
                return Pair(current.data!!, position)
            }
            current = current.next
        }
        return null
    }

    //1,2,(3,4,5),6
    fun reverseFromToPosition(from: Int, to: Int) {
        if (head == null || from == to) println("n/a")
        var length = 0
        var temp = head
        while (temp != null) {
            length++
            temp = temp.next
        }
        println("Length: $length")

        if (from > to || from > length || to > length)
            println("Invalid Range! ($from..$to)")

        var current = head
        var previous: Node<T>? = null
        for (i in 1 until from) {
            previous = current
            current = current?.next
        }

        val connectionPoint = previous
        val tail = current
        var next: Node<T>? = null

        for (i in from..to) {
            next = current?.next
            current?.next = previous
            previous = current
            current = next
        }

        if (connectionPoint?.next != null) {
            connectionPoint.next = previous
        } else {
            head = previous
        }

        tail?.next = current

        //print the list
        printLinkedList()
    }

    fun detectAndRemoveLoop() {
        var slow = head
        var fast = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) {
                //loop detected
                removeLoop(slow)
                println("Loop detected at ${slow?.data}")
                break
            }
        }
    }

    private fun removeLoop(loopNode: Node<T>?) {
        var ptr1 = head
        val ptr2 = loopNode
        while (ptr2?.next != ptr1) {
            ptr1 = ptr1?.next
        }
        head = ptr1
        ptr2?.next = null
    }

    /**
     * Remove nth node from the end of the Linked List
     */
//    fun removeNthNodeFromEnd(n: Int) {
//        val dummy = SingleNode<T>(data = null)
//        dummy.next = head
//        var slow: SingleNode<T>? = dummy
//        var fast: SingleNode<T>? = dummy
//
//        for (i in 1..n) {
//            if (fast == null) {
//                print("Index Out Of Bound")
//                return
//            }
//            fast = fast.next
//        }
//
//        while (fast != null) {
//            fast = fast.next
//            slow = slow?.next
//        }
//
//        slow?.next = slow?.next?.next
//
//        head = dummy.next
//
//        printLinkedList()
//    }

    /**
     * Remove Duplicates from Sorted List
     */
    fun removeDuplicates() {

        if (head == null) {
            println("List is Empty")
            return
        }

        val set = mutableSetOf<T>()


        var current = head
        var previous = Node<T>(data = null, null)
        previous.next = head

        while (current != null) {
            current.data?.let { data ->
                if (set.add(data)) {
                    previous = current as Node<T>
                    current = current?.next
                } else {
                    val duplicate = current
                    previous.next = duplicate?.next
                    current = current?.next
                    duplicate?.next = null
                }
            }
        }
        printLinkedList()
    }

    /**
     * Remove Duplicates From Sorted LinkedList
     */
    fun removeDuplicatesFromSortedLinkedList() {
        var current = head
        while (current?.next != null) {
            if (current.data == current.next?.data) {
                val duplicate = current.next
                current.next = duplicate?.next
                duplicate?.next = null
            } else {
                current = current.next
            }
        }
        printLinkedList()
    }

    fun printLinkedList() {
        println()
        var current = head
        while (current != null) {
            if (current.next == null) print("${current.data}")
            else print("${current.data} => ")
            current = current.next
        }
    }
}