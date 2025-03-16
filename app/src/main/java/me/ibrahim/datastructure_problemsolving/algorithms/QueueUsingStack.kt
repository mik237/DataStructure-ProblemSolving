package me.ibrahim.datastructure_problemsolving.algorithms

import java.util.LinkedHashMap
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() {
    val queue = QueueUsingStack<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    println(queue.dequeue())
    println(queue.dequeue())
    queue.enqueue(4)
    queue.enqueue(5)
    println(queue.dequeue())
    queue.enqueue(6)
    println(queue.dequeue())
    println(queue.dequeue())

    val q = LinkedList<Int>().also {
        it.add(1)
        it.add(2)
        it.add(3)
        it.add(4)
        it.add(5)

       // reverseFirstKElements<Int>(it, 3)
        reverseFirstKElements(it, 3, "")
    }
}


class QueueUsingStack<T> {

    private val stack = Stack<T>()
    private val copy = Stack<T>()

    fun enqueue(item: T) {
        stack.push(item)
    }

    fun dequeue(): T? {
        if (stack.isEmpty() && copy.isEmpty()) return null

        if (copy.isEmpty()) {
            while (stack.isNotEmpty()) {
                copy.push(stack.pop())
            }
        }
        return copy.pop()
    }

    fun isEmpty() = stack.isEmpty() && copy.isEmpty()

    fun peek(): T? {
        if (stack.isEmpty() && copy.isEmpty()) return null

        if (copy.isEmpty()) {
            while (stack.isNotEmpty()) {
                copy.push(stack.pop())
            }
        }

        return copy.peek()
    }
}


fun <E> reverseFirstKElements(queue: Queue<E>, k: Int) {
    println(queue)

    if (k <= 0 || queue.isEmpty() || k > queue.size) {
        println("Invalid K value")
        return
    }

    val stack = Stack<E>()

    for (i in 1..k) {
        stack.push(queue.remove())
    }

    while (stack.isNotEmpty()) {
        queue.add(stack.pop())
    }

    for (i in 1..(queue.size - k)) {
        queue.add(queue.remove())
    }

    println(queue)
}

fun <E> reverseFirstKElements(list: List<E>, k: Int, a: String) {
    println(list)
    if (k > list.size) {
        println(list.reversed())
        return
    }

    val firstKItems = list.take(k).reversed()
    val remainingItems = list.drop(k)

    println(firstKItems + remainingItems)
}
