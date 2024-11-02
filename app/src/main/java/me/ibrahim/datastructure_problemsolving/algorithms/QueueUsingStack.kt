package me.ibrahim.datastructure_problemsolving.algorithms

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