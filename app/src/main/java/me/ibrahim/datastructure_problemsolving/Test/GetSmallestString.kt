package me.ibrahim.datastructure_problemsolving.Test


/*
 * Complete the 'getSmallestString' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING dataSequence
 *  2. INTEGER maxSwaps
 */

fun getSmallestString(dataSequence: String, maxSwaps: Int): String {
    if (dataSequence.isEmpty() || maxSwaps <= 0 || !dataSequence.contains('0'))
        return dataSequence

    val charArray = dataSequence.toCharArray()
    //11011010
    //01101010
    //1001110

    repeat(maxSwaps) {
        var indexOfZero = charArray.indexOf('0')
        if (indexOfZero == 0) {
            for ((i, c) in charArray.withIndex()) {
                if (i > 0 && c == '0') {
                    indexOfZero = i
                    break
                }
            }
        }

        if (indexOfZero > 0) {
            charArray[indexOfZero] = '1'
            charArray[indexOfZero - 1] = '0'
        }

    }

    return String(charArray)
}

fun getSmallestStringV2(dataSequence: String, maxSwaps: Int): String {
    if (dataSequence.isEmpty() || maxSwaps <= 0 || !dataSequence.contains('0')) {
        return dataSequence
    }

    val charArray = dataSequence.toCharArray()
    var swapsLeft = maxSwaps

    //11011010
    //01101010
    //1001110
    for (i in charArray.indices) {
        //2 -> 10111010
        if (charArray[i] == '0') {
            var j = i

            // Move '0' to the left as much as possible within available swaps
            while (j > 0 && swapsLeft > 0 && charArray[j - 1] == '1') {
                charArray[j] = '1'
                charArray[j - 1] = '0'
                j--
                swapsLeft--

                // If swaps are exhausted, return the result immediately
                if (swapsLeft == 0) {
                    return String(charArray)
                }
            }
        }
    }

    return String(charArray)
}

fun main() {
    println(getSmallestString("11011010", 5))
}