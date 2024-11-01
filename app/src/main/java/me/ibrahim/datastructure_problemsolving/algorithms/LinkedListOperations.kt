package me.ibrahim.datastructure_problemsolving.algorithms

import kotlin.math.sin

fun main() {
    val singleLinkedList = SingleLinkedList<String>()
    singleLinkedList.insertAtBeginning("A")
    singleLinkedList.insertAtEnd("B")
    singleLinkedList.insertAtEnd("C")
    singleLinkedList.insertAtEnd("D")
    singleLinkedList.insertAfter("G", "B")

    println(singleLinkedList.search("D"))

}

class SingleNode<T>(val data: T) {
    var next: SingleNode<T>? = null
}

class SingleLinkedList<T> {

    private var head: SingleNode<T>? = null

    //insert, insertAt, insertAtEnd, delete, deleteAt search, print


    fun insertAtBeginning(data: T) {
        val singleNode = SingleNode(data = data)
        singleNode.next = head
        head = singleNode
    }

    fun insertAtEnd(data: T) {
        val singleNode = SingleNode(data = data)
        if (head == null) {
            head = singleNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = singleNode
        }
    }

    fun insertAfter(data: T, after: T) {
        val newNode = SingleNode(data = data)

        if (head == null) {
            head = newNode
        } else {
            var current = head

            while (current != null) {
                if (current.data == after) {
                    newNode.next = current.next
                    current.next = newNode
                    break
                }
                current = current.next
            }
        }
    }

    fun deleteFromBeginning() {
        head?.let {
            var tempHead = head
            head = head?.next
            tempHead?.next = null
            tempHead = null
        }
    }

    fun deleteFromEnd() {
        if (head == null)
            return
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
                return Pair(current.data, position)
            }
            current = current.next
        }
        return null
    }

    fun printLinkedList() {
        println()
        var current = head
        while (current != null) {
            if (current.next == null)
                print("${current.data}")
            else
                print("${current.data} => ")
            current = current.next
        }
    }
}