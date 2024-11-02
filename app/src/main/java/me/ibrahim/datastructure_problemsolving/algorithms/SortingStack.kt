package me.ibrahim.datastructure_problemsolving.algorithms

import java.util.Stack


fun main() {
    val sortingStack = SortingStack()
    val stack = Stack<Int>()
    stack.push(0)
    stack.push(9)
    stack.push(1)
    stack.push(6)
    stack.push(2)
    stack.push(4)
    stack.push(3)
    sortingStack.sort(stack)
}

class SortingStack {

    fun <T : Comparable<T>> sort(inputStack: Stack<T>) {
        val sorted = Stack<T>()

        if (inputStack.isEmpty()) {
            println("Empty stack")
            return
        }

        while (inputStack.isNotEmpty()) {

            val top = inputStack.pop()

            //descending order with < sign
            while (sorted.isNotEmpty() && sorted.peek() < top) {
                inputStack.push(sorted.pop())
            }

            sorted.push(top)
        }
        println(sorted)
    }
}