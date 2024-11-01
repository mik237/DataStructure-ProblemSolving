package me.ibrahim.datastructure_problemsolving.algorithms

import androidx.compose.ui.util.fastForEachReversed


fun main() {
//    Algorithms.findFirstNonRepeatedChar("goubemhkhgbvdkhoiubdkhkvfkhweiugdkjvhdskfhskbksfdwoeu")

//    Algorithms.areAnagrams("listen", "silent")

//    Algorithms.mostFrequentElement(intArrayOf(1, 2, 3, 4, 5, 4, 3, 5, 6, 10, 4, 3, 6, 7, 1, 0, 4))

//    Algorithms.checkDuplicates(intArrayOf(1, 2, 3, 4, 5))

//    Algorithms.intersection(intArrayOf(9, 2, 5, 7, 4, 5), intArrayOf(1, 2, 3, 4, 5))

//    Algorithms.removeDuplicates(intArrayOf(9, 2, 5, 5, 5, 5, 7, 7, 4, 5))

//    Algorithms.reverseWords("hello world dubai uae")

//    Algorithms.reverseStringUsingRecursion("Hello world").let {
//        print("Reverse with Recursion: $it")
//    }

//    Algorithms.countCharOccurrences("helloWorld")

//    Algorithms.findPairWithSum(intArrayOf(1, 2, 7, 11, 15), 45)

//    Algorithms.findMaxAndMin(intArrayOf())

//    Algorithms.reverseArray(intArrayOf(1, 2, 3, 4, 5))

//    Algorithms.findMinAbsoluteDifference(intArrayOf(50, 16, 3, 8, 15, 17))

//    Algorithms.maxLenWithZeroSum(intArrayOf(1, 2, 3, -1, -2, -5, -4, 4, -6, -7))

    Algorithms.firstUniqueCharacterInString("hellowworrldh")
}

object Algorithms {

    //Write a function that finds the first non-repeated character in a string.
    fun findFirstNonRepeatedChar(input: String) {
        val charFrequency = mutableMapOf<Char, Int>()

        for (i in input) {
            charFrequency[i] = (charFrequency[i] ?: 0) + 1
        }

        println(charFrequency)

        val firstRepeating = input.firstOrNull { charFrequency[it]!! > 1 }
        val firstNonRepeating = input.firstOrNull { charFrequency[it] == 1 }

        println("NonRepeating: $firstNonRepeating")
        println("Repeating: $firstRepeating")
    }


    //Write a function to check if two strings are anagrams.
    //if both the strings contain same characters, regardless of order.
    //.e.g. silent == listen ==> true
    fun areAnagrams(str1: String, str2: String) {
        println(str1)
        println("Sorted-1: ${str1.toCharArray().sorted()}")
        println(str2)
        println("Sorted-2: ${str2.toCharArray().sorted()}")

//        referencial equality which will return false (comparing references of two objects)
//        val anagram = str1.toCharArray().sorted() === str2.toCharArray().sorted()

        val anagram = str1.toCharArray().sorted() == str2.toCharArray().sorted()
        println("Anagram: $anagram")
    }


    /**
     *  Find the Most Frequent Element in an Array
     */
    fun mostFrequentElement(arr: IntArray) {
        println(arr.sorted())
        val group = arr.groupBy { it }
        println(group)
        val frequencyMap = group.mapValues {
            it.value.size
        }

        println(frequencyMap)

        val frequent = frequencyMap.maxByOrNull { it.value }?.key

        println("frequent: $frequent")
    }


    /**
     * Check for Duplicates in an Array
     */
    fun checkDuplicates(arr: IntArray) {
        var duplicates = false
        val uniqueElements = mutableSetOf<Int>()

        for (i in arr) {
            //returns false if not added. i.e. value already exist in Set
            if (uniqueElements.add(i).not()) {
                duplicates = true
                break
            }
        }
        println("Duplicate: $duplicates")
    }


    /**
     * Find the Intersection of Two Arrays.
     * since intersection is usually applied on Sets, so converting to sets
     */
    fun intersection(arr1: IntArray, arr2: IntArray) {
        val set1 = arr1.toSet()
        val set2 = arr2.toSet()

        val intersection = set1.filter { set2.contains(it) }
        println("intersection: $intersection")

        //alternate method is intersection
        /*val intersection2 = set1.intersect(set2)
        println("intersection2: $intersection2")*/
    }


    /**
     * Remove Duplicates from an Array
     */
    fun removeDuplicates(arr: IntArray) {
        //using toSet() function
        /*val withoutDuplicates = arr.toSet()
        println(withoutDuplicates)*/

        val unique = mutableListOf<Int>()
        for (a in arr) {
            if (unique.contains(a).not()) unique.add(a)
        }
        println(unique)
    }


    /**
     * Reverse Words in a Sentence
     */
    fun reverseWords(sentence: String) {
        //reversing words in string.
        val reversedStr = sentence.split(" ").reversed()
        println(reversedStr)

        //reversing words & then reversing characters of each word.
        sentence.split(" ").fastForEachReversed {
            println(it.reversed())
        }

        //using iteration
        var reversedStr2 = ""
        for (i in sentence.length - 1 downTo 0) {
            reversedStr2 += sentence[i]
        }
        println("using iteration: $reversedStr2")

        //another approach using StringBuilder#reverse function
        var reversedStr3 = StringBuilder(sentence).reverse()
        println("reversedStr3: $reversedStr2")

    }

    fun reverseStringUsingRecursion(sentence: String): String {
        if (sentence.isEmpty()) return ""
        else return reverseStringUsingRecursion(sentence.substring(1)) + sentence[0]
    }


    /**
     * Count Occurrences of Each Character
     */
    fun countCharOccurrences(input: String) {
        //Method # 1
        val group = input.toCharArray().groupBy { it }.mapValues { it.value.size }
        println(group)

        //Method # 2
        val map = mutableMapOf<Char, Int>()
        for (c in input) {
            map[c] = (map[c] ?: 0) + 1
        }
        println(map)
    }

    /**
     * Write a function that finds a pair of numbers in an array that add up to a specific target.
     */
    fun findPairWithSum(arr: IntArray, target: Int) {
        println(arr.toList())

        //Method #1
        val seenNumbers = arr.toMutableList()
        for (a in arr) {
            val b = target - a
            seenNumbers.remove(a)
            if (seenNumbers.contains(b)) {
                println(Pair(a, b))
                break
            }
        }

        //Method #2
        val seenNumbersSet = mutableSetOf<Int>()
        for (a in arr) {
            val b = target - a
            if (seenNumbersSet.contains(b)) {
                println(Pair(b, a))
                break
            }
            seenNumbersSet.add(a)
        }
    }


    /**
     * Find max & min in the array
     */
    fun findMaxAndMin(arr: IntArray) {
        println(arr.toList())

        if (arr.isEmpty()) {
            println("Max: null, Min: null")
        } else {
            var max = arr[0]
            var min = arr[0]
            for (i in 1..arr.lastIndex) {
                if (arr[i] > max) max = arr[i]
                if (arr[i] < min) min = arr[i]
            }
            println("Max: $max, Min: $min")
        }

        //using buildIn functions on IntArray
        println(".max(): ${arr.maxOrNull()}, .min(): ${arr.minOrNull()}")
    }

    /**
     * Reverse an array
     */
    fun reverseArray(arr: IntArray) {

        println(arr.toList())

        /*reverse() & reversed() are two built-in functions*/
//        arr.reverse() //reverses the actual content of the array.
        val reverse = arr.reversed() //returns a new list with content reversed of original array.
        println(reverse)

        val reversedList = mutableListOf<Int>()
        for (i in arr.lastIndex downTo 0) {
            reversedList.add(arr[i])
        }
        println(reversedList)
    }

    /**
     * Minimum Absolute Difference in an Array.
     * smallest absolute difference between any two elements in an array
     */
    fun findMinAbsoluteDifference(arr: IntArray) {
        if (arr.size < 2) {
            //if arr size is less than 2, there is no pair possible, hence difference is 0
            print(0)
        } else {
            arr.sort()
            var minAbsDiff = Int.MAX_VALUE
            var a = arr[0]
            var b = arr[1]
            for (i in 0..<arr.lastIndex) {
                val absDiff = kotlin.math.abs(arr[i] - arr[i + 1])
                if (absDiff < minAbsDiff) {
                    a = arr[i]
                    b = arr[i + 1]
                    minAbsDiff = absDiff
                }
            }
            println("Min Abs Diff ($a, $b): $minAbsDiff")
        }

    }


    fun maxLenWithZeroSum(arr: IntArray): Int {
        val prefixSumMap = mutableMapOf<Int, Int>()  // HashMap to store prefixSum and its first occurrence index
        var prefixSum = 0  // Initialize prefixSum
        var maxLength = 0  // To keep track of the maximum length of subarray with sum 0

        /*for (i in arr.indices) {
            prefixSum += arr[i]  // Update the prefixSum with the current element

            // Check if prefixSum is 0, meaning subarray from start to i has 0 sum
            if (prefixSum == 0) {
                maxLength = i + 1  // Update maxLength as subarray from 0 to i has 0 sum
            }

            // If prefixSum has been seen before, calculate the length of subarray with 0 sum
            if (prefixSum in prefixSumMap) {
                val previousIndex = prefixSumMap[prefixSum]!!
                maxLength = maxOf(maxLength, i - previousIndex)
            } else {
                // Store the first occurrence of prefixSum
                prefixSumMap[prefixSum] = i
            }
        }*/

        //My solution
        for (i in arr.indices) {
            prefixSum += arr[i]

            if (prefixSum == 0) {
                maxLength = i + 1
            }

        }
        println("Max length: $maxLength")
        return maxLength
    }


    fun firstUniqueCharacterInString(s: String) {
        //Method #1
        val uniqueChar = s.toCharArray().groupBy { it }.mapValues { it.value.size }.filter { it.value == 1 }.keys.firstOrNull()
        println("Unique char in $s : $uniqueChar")


        //Method #2
        val frequencyMap = mutableMapOf<Char, Int>()
        for (c in s) {
            frequencyMap[c] = (frequencyMap[c] ?: 0) + 1
        }

        val uniqueChar2 = frequencyMap.filter { it.value == 1 }.keys.firstOrNull()
        println("Unique char2 in $s : $uniqueChar2")

    }

}