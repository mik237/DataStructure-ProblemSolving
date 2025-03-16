package me.ibrahim.datastructure_problemsolving.Test

import java.util.Locale
import kotlin.math.abs

fun plusMinus(arr: IntArray) {
    val size = arr.size
    val group = arr.groupBy {
        when {
            it > 0 -> "positive"
            it < 0 -> "negative"
            else -> "zero"
        }
    }.mapValues { it.value.size }.map { "%.6f".format(it.value.toDouble() / size) }

    group.forEach {
        println(it)
    }
}


fun miniMaxSum(arr: IntArray) {
    // Write your code here
    if (arr.size < 5) {
        println("Error: Array must contain at least 5 elements.")
        return
    }

    var totalSum = 0L  // Use Long to avoid overflow
    var minElement = Long.MAX_VALUE
    var maxElement = Long.MIN_VALUE

    for (num in arr) {
        val longNum = num.toLong() // Convert to Long to avoid overflow
        totalSum += longNum
        minElement = minOf(minElement, longNum)
        maxElement = maxOf(maxElement, longNum)
    }

    val minSum = totalSum - maxElement
    val maxSum = totalSum - minElement

    println("$minSum $maxSum")
}

fun timeConversion(s: String): String {
    // Write your code here

    if (s.isEmpty() || s.trim().length != 10) {
        return ""
    }

    val period = s.takeLast(2) // Get AM/PM
    val (hours, minutes, seconds) = s.dropLast(2).split(":").map { it.toInt() }

    val militaryHours = when {
        period == "AM" && hours == 12 -> 0  // Convert 12AM to 00
        period == "PM" && hours != 12 -> hours + 12  // Convert PM hours (except 12PM)
        else -> hours
    }

    val result = String.format(Locale.getDefault(), "%02d:%02d:%02d", militaryHours, minutes, seconds)
    println(result)
    return result
}


fun fizzBuzz(n: Int) {
    (1..n).forEach {
        when {
            it % 3 == 0 && it % 5 == 0 -> {
                println("FizzBuzz")
            }

            it % 3 != 0 && it % 5 == 0 -> {
                println("Buzz")
            }

            it % 3 == 0 && it % 5 != 0 -> {
                println("Fizz")
            }

            else -> {
                println("$it")
            }
        }
    }
}

fun findMedian(arr: IntArray): Int {
    // Write your code here
    if (arr.size < 3) {
        return -1
    }
    arr.sort()
    val midIndex = arr.lastIndex / 2
    return arr[midIndex]
}

fun lonelyinteger(a: Array<Int>): Int {
    // Write your code here
    val lonely = a.groupingBy { it }.eachCount().filterValues { it == 1 }.keys.firstOrNull()
    println(lonely)
    return lonely ?: -1

//    Method 2
//    return a.reduce { acc, num -> acc xor num }

}


fun diagonalDifference(arr: Array<Array<Int>>): Int {
    // Write your code here
    var primaryDiagnolSum = 0
    var secondaryDiagnolSum = 0

    for (i in arr.indices) {
        primaryDiagnolSum += arr[i][i]
        secondaryDiagnolSum += arr[i][arr.size - i - 1]
    }
    return abs(primaryDiagnolSum - secondaryDiagnolSum)
}

fun main() {
//    miniMaxSum(intArrayOf(4, 3, 9, 2, 1))

    /*timeConversion("07:05:45PM")
    timeConversion("12:05:45AM")
    timeConversion("12:00:00AM")*/

    val mid = findMedian(intArrayOf(51, 13, 11, 21, 14))
    println(mid)

}