package me.ibrahim.datastructure_problemsolving.algorithms

fun main() {
    val singleLinkedList = SingleLinkedList<String>()
    singleLinkedList.insertAtBeginning("A")
    singleLinkedList.insertAtEnd("B")
    singleLinkedList.insertAtBeginning("C")
    singleLinkedList.insertAtEnd("D")
    singleLinkedList.printLinkedList()

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

    fun printLinkedList() {
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