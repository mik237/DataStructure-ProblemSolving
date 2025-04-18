package me.ibrahim.datastructure_problemsolving.algorithms

import androidx.collection.mutableIntListOf
import androidx.compose.ui.util.fastForEachReversed
import java.util.Stack
import kotlin.math.abs


fun main() {/*    Algorithms.findFirstNonRepeatedChar("goubemhkhgbvdkhoiubdkhkvfkhweiugdkjvhdskfhskbksfdwoeu")


        Algorithms.mostFrequentElement(intArrayOf(1, 2, 3, 4, 5, 4, 3, 5, 6, 10, 4, 3, 6, 7, 1, 0, 4))

        Algorithms.checkDuplicates(intArrayOf(1, 2, 3, 4, 5))

        Algorithms.intersection(intArrayOf(9, 2, 5, 7, 4, 5), intArrayOf(1, 2, 3, 4, 5))

        Algorithms.removeDuplicates(intArrayOf(9, 2, 5, 5, 5, 5, 7, 7, 4, 5))



        Algorithms.reverseStringUsingRecursion("Hello world").let {
            print("Reverse with Recursion: $it")
        }

        Algorithms.countCharOccurrences("helloWorld")

        Algorithms.findPairWithSum(intArrayOf(1, 2, 7, 11, 15), 45)

        Algorithms.findMaxAndMin(intArrayOf())

        Algorithms.reverseArray(intArrayOf(1, 2, 3, 4, 5))



        Algorithms.maxLenWithZeroSum(intArrayOf(1, 2, 3, -1, -2, -5, -4, 4, -6, -7))

        Algorithms.firstUniqueCharacterInString("hellowworrldh")



        val stack = Stack<String>()
        stack.push("A")
        stack.push("B")
        stack.push("C")
        stack.push("D")
        stack.push("E")
        Algorithms.reverseStack(stack)

        Algorithms.moveZeroesToEnd(intArrayOf(1, 2, 0, 0, 3))

        Algorithms.findFactorial(5)
        */

//    Algorithms.linearSearch(intArrayOf(1, 2, 7, 7, 4), 7)
//    Algorithms.selectionSort(intArrayOf(10, 2, 5, 7, 4))
//    Algorithms.insertionSort(intArrayOf(10, 2, 5, 7, 4))

//    println(Algorithms.mergeSort(intArrayOf(10, 2, 5, 7, 4)).contentToString())

//    println("Output: ${Algorithms.removeVowels("aehelloworldibrahimu")}")
//    println("Output: ${Algorithms.calculateRunningSum(intArrayOf(1,2,3,4)).toList()}")
//    println("Most common word: ${Algorithms.mostCommonWord("..Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit"))}")
//    println("${Algorithms.productOfAllElementsExceptSelf(intArrayOf(2, 3, 4))}")
//    Algorithms.majorityElement(intArrayOf(3, 3, 4, 2, 4, 4, 2, 4, 4))

//    Algorithms.longestUniqueSubstring("abcabcbb")
//    Algorithms.longestUniqueSubstring("geeksforgeeks")

//    Algorithms.minimumSizeSubArrayWithMaxSum(intArrayOf(7, 6, 13, 12, 11))
//    Algorithms.minimumSizeSubArrayWithMaxSum(intArrayOf(2, 3, -2, 1, 4, -1, 2, -3, 5))
//    Algorithms.minimumSizeSubArrayWithMaxSum(intArrayOf(1, 2, 3))
//    println("Reversed: ${Algorithms.reverseStr("ibrahim")}")
//    Algorithms.balanceParanthesisUsingStack("[({(a+b))}]")

//    Algorithms.findMinAbsoluteDifference(intArrayOf(50, 20, 3, 8, 15, 17))
//    Algorithms.reverseWords("hello world dubai uae")

//    Algorithms.areAnagrams("listen", "silent")
//    Algorithms.arePermutations("dabce", "ebacf")

//    Algorithms.findDuplicatesInArray(intArrayOf(1, 3, 2, 0, 1, 0, 1))
//    println(Algorithms.maxPairwiseSum(listOf(1, 2, 3), listOf(4, 5)))
//    println(Algorithms.countFrequencies(listOf(1, 2, 3, 1,1, 2, 3, 4, 5, 4)))
//    Algorithms.flattenListOfLists(listOf(listOf(3, 4), listOf(13, 14, 15), listOf(10, 20, 30, 40)))
//    Algorithms.longestCommonPrefix(listOf("Flower", "Flower", "Flight"))
//    Algorithms.rotateArray(intArrayOf(1, 2, 3, 4), 1)
//    Algorithms.rotateArrayToLeft(intArrayOf(1, 2, 3, 4), 1)

//    Algorithms.bubbleSort(intArrayOf(10, 2, 5, 7, 4, 11, 1, 3, 9, 21, 12, 6, 8))
    Algorithms.twoSum(intArrayOf(1, 2, 3, 4), 7)

}

object Algorithms {
    //    (1, 2, 3, 4), 5
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val seen = mutableIntListOf() //1, 2,

        for (a in nums) {  //1, 2, 3
            val b = target - a //4, 3, 2
            if (seen.contains(b)) {
                println("TwoSum: $b, $a")
                break
            }
            seen.add(a)
        }
        return intArrayOf(0, 1)
    }

    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val words = paragraph.lowercase().split("\\W+|\\s+".toRegex()).filterNot { it.isEmpty() }
        val bannedWords = banned.toHashSet()

        val wordsToCount = words.filterNot { it in bannedWords }.groupingBy { it }.eachCount()
        return wordsToCount.maxBy { it.value }.key
    }

    fun findMostFrequent(nums: IntArray): Int {
        val grouping = nums.toList().groupingBy { it }
        val count = grouping.eachCount()
        return count.maxBy { it.value }.key
    }

    //input: [1,2,3,4] => output: [1,3,6,10]
    fun calculateRunningSum(nums: IntArray): IntArray {
        return nums.runningReduce { acc, element -> acc + element }.toIntArray()
    }

    fun removeVowels(str: String): String {
        val vowels = charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        return str.filter {
            it !in vowels
        }
    }

    /*************************************************/

    fun mergeSort(arr: IntArray): IntArray {
        if (arr.size <= 1) return arr
        val middle = arr.size / 2
        val left = arr.sliceArray(0 until middle)
        val right = arr.sliceArray(middle until arr.size)
        return merge(mergeSort(left), mergeSort(right))
    }

    private fun merge(left: IntArray, right: IntArray): IntArray {
        var i = 0
        var j = 0
        val merged = mutableListOf<Int>()
        while (i < left.size && j < right.size) {
            if (left[i] <= right[j]) merged.add(left[i++])
            else merged.add(right[j++])
        }
        while (i < left.size) merged.add(left[i++])
        while (j < right.size) merged.add(right[j++])
        return merged.toIntArray()
    }

    /**********************/
    fun insertionSort(arr: IntArray) {
        println(arr.contentToString())
        for (i in 1 until arr.size) {
            val key = arr[i]
            var j = i - 1
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j -= 1
            }
            arr[j + 1] = key
        }
        println(arr.contentToString())
    }

    //O(n^2)
    fun selectionSort(arr: IntArray) {
        println(arr.contentToString())
        for (i in arr.indices) {
            var minIndex = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[minIndex]) minIndex = j
            }
            val temp = arr[i]
            arr[i] = arr[minIndex]
            arr[minIndex] = temp
        }
        println(arr.contentToString())
    }

    //[5, 3, 8, 4, 2]
    fun bubbleSort(arr: IntArray) {
        println(arr.contentToString())
        val n = arr.size
        for (i in arr.indices) {
            for (j in 0 until arr.size - 1) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
        println(arr.contentToString())
    }

    fun linearSearch(arr: IntArray, key: Int) {
        if (arr.isEmpty()) {
            println("Not found. Array is Empty")
            return
        }

        var found = false
        for (i in arr.indices) {
            if (arr[i] == key) {
                found = true
                println("$key found at index: $i")
                break
            }
        }
        if (found.not()) {
            println("$key not found")
        }
    }

    fun binarySearch(arr: IntArray, key: Int) {
        if (arr.isEmpty()) println("Not found. Array is Empty")

        arr.sorted()
        var left = 0
        var right = arr.lastIndex
        var found = false

        while (left < right) {
            val midIndex = (left + right) / 2
            if (arr[midIndex] == key) {
                found = true
                println("$key found at index: $midIndex")
                break
            } else if (arr[midIndex] > key) {
                right = midIndex - 1
            } else left = midIndex + 1
        }
        if (found.not()) {
            println("$key not found")
        }
    }

    fun rotateArrayToLeft(arr: IntArray, steps: Int) {
        println(arr.contentToString())
        val k = steps % arr.size

        //Method 1
        /*for (i in 0 until k) {
            val first = arr[0]
            for (j in 1 until arr.size) {
                arr[j - 1] = arr[j]
            }
            arr[arr.lastIndex] = first
        }
        println(arr.contentToString())*/

        val result = arr.sliceArray(k until arr.size) + arr.sliceArray(0 until k)
        println("Result: ${result.contentToString()}")
    }

    fun reverseArray1(arr: IntArray) {
        println(arr.contentToString())
        var left = 0
        var right = arr.lastIndex
        while (left < right) {
            val temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
            left++
            right--
        }
        println(arr.contentToString())
    }

    fun rotateArray(arr: IntArray, k: Int) {
        println(arr.contentToString())
        val steps = k % arr.size
        val n = arr.size
        /*arr.reverse()
        arr.reverse(0, steps)
        arr.reverse(steps, arr.size)
        println(arr.contentToString())*/

        val result = arr.sliceArray(n - steps until n) + arr.sliceArray(0 until n - steps)
        println(result.contentToString())
    }

    //5! = 5*4*3*2*1
    fun findFactorial(n: Int) {
//        Method 1 using reduce function
        val factReduce = (1..n).reduce { acc, i -> acc * i }
        println(factReduce)

//        Method 2 using loop
        var factLoop = 1
        for (i in 1..n) {
            factLoop *= i
        }
        println(factLoop)
    }

    fun longestCommonPrefix(strings: List<String>) {
        val commonPrefix = strings.reduce { acc, s ->
            acc.commonPrefixWith(s)
        }
        println("Prefix: $commonPrefix")

        //Method 2
        var commPrefix = strings[0]
        for (i in 1..strings.lastIndex) {
            commPrefix = commPrefix.commonPrefixWith(strings[i])
            if (commPrefix.isEmpty())
                break
        }
        println("Method2 Prefix: $commPrefix")

    }

    /**
     * Find Elements Present in Only One of Two Lists (Symmetric Difference)
     */
    fun symmetricDifference(list1: List<Int>, list2: List<Int>): Set<Int> {
//        Method 1
//        return (list1 + list2).groupBy { it }.mapValues { it.value.size }.filter { it.value == 1 }.keys

//      Method 2
        return (list1 + list2).groupingBy { it }.eachCount().filter { it.value == 1 }.keys

        //Method 3
//        return (list1.toSet() - list2.toSet()) + (list2.toSet() - list1.toSet())
    }

    fun flattenListOfLists(listOfLists: List<List<Int>>) {
        val updated = listOfLists.flatMap {
            it
        }
        println(updated)
        println(listOfLists.flatten())
    }

    fun countFrequencies(nums: List<Int>) {
        val grouping = nums.groupingBy { it }
        val count = grouping.eachCount()
        println(count)
    }


    fun maxPairwiseSum(list1: List<Int>, list2: List<Int>): Int {
        return list1.zip(list2).maxOf { it.first + it.second }
    }

    /**
     * Find all elements that appear twice in an array without using extra space and in O(n) time.
     * i.e. in O(n) & space O(1)
     */
    fun findDuplicatesInArray(arr: IntArray) {

        val duplicates = mutableListOf<Int>()
        var zeroCount = 0

        for (i in arr.indices) {
            val num = kotlin.math.abs(arr[i])  // Get absolute value

            if (num == 0) {
                zeroCount++
                if (zeroCount == 2) duplicates.add(0)  // Add only once when found twice
                continue
            }
            val index = num - 1  // Handle 0 separately

            if (arr[index] < 0) {
                duplicates.add(num)
            } else {
                arr[index] = -arr[index]
            }
        }

        println("Duplicate: $duplicates")
    }

    //[1,2,0,3,0,4,5] => [1,2,3,4,5,0,0]
    fun moveZeroesToEnd(nums: IntArray) {
        var zeroFoundAt = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[zeroFoundAt++] = nums[i]
            }
        }
        for (i in zeroFoundAt until nums.size) {
            nums[i] = 0
        }
        println(nums.toList())
    }

    fun arePermutations(str1: String, str2: String) {
        if (str1.length != str2.length) {
            println("Not Permutations")
            return
        }

        /*val permutation = str1.toCharArray().sorted() == str2.toCharArray().sorted()
        if (permutation)
            println("Permutations")
        else
            println("Not Permutations")*/

        val str1Map = mutableMapOf<Char, Int>()
        val str2Map = mutableMapOf<Char, Int>()

        for (i in str1.indices) {
            val c1 = str1.getOrNull(i)
            val c2 = str2.getOrNull(i)
            c1?.let {
                str1Map[it] = (str1Map[it] ?: 0) + 1
            }
            c2?.let {
                str2Map[it] = (str2Map[it] ?: 0) + 1
            }
        }

        if (str1Map == str2Map) {
            println("Map: Permutations")
        } else {
            println("Map: Not Permutations")
        }

        val str1map = str1.groupBy { it }.mapValues { it.value.size }
        val str2map = str2.groupBy { it }.mapValues { it.value.size }

        if (str1map == str2map) {
            println("map: Permutations")
        } else {
            println("map: Not Permutations")
        }
    }


    //Write a function that finds the first non-repeated character in a string.
    fun findFirstNonRepeatedChar(input: String) {
        if (input.isEmpty())
            return

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

        println("Anagram: ${str1.toSet().intersect(str2.toSet()) == str1.toSet()}")

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
            print("${it.reversed()} ")
        }
        println()

        //using iteration
        var reversedStr2 = ""
        for (i in sentence.lastIndex downTo 0) {
            reversedStr2 += sentence[i]
        }
        println("using iteration: $reversedStr2")

        //another approach using StringBuilder#reverse function
        val reversedStr3 = StringBuilder(sentence).reverse()
        println("reversedStr3: $reversedStr3")

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

            //Method #2
            max = arr.max()
            min = arr.min()
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
            var minAbsDiff = Int.MAX_VALUE
            var a = arr[0]
            var b = arr[1]
            for (i in 0..<arr.lastIndex) {
                val absDiff = abs(arr[i] - arr[i + 1])
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

        //Method #3
        val unikChar = s.toCharArray().toList().groupingBy { it }.eachCount().filterValues { it == 1 }.keys.firstOrNull()
    }

    //"[{()}]"  --> ({[ -->
    fun balanceParanthesisUsingStack(expr: String) {

        if (expr.isEmpty()) {
            println("Empty String")
            return
        }

        val stack = ArrayDeque<Char>()

        for (char in expr) {
            when (char) {
                '(', '{', '[' -> {
                    stack.addFirst(char)
                }

                ')', '}', ']' -> {
                    val top = stack.removeFirstOrNull()
                    if (matchChar(top, char).not()) {
                        println("Not Balanced Paranthesis")
                        return
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            println("Balanced Paranthesis")
        }
    }

    private fun matchChar(top: Char?, char: Char): Boolean {
        return (top == '(' && char == ')') || (top == '{' && char == '}') || (top == '[' && char == ']')
    }


    /**
     * Reverse a string using recursion
     */
    fun reverseStr(str: String): String {
        return if (str.isEmpty()) ""
        else reverseStr(str.substring(1)) + str[0]
    }

    /**
     * Reverse a stack using recursion
     */
    fun <T> reverseStack(stack: Stack<T>) {
        if (stack.isEmpty()) return
        val item = stack.pop()
        reverseStack(stack)
        insertAtBottom(stack, item)
        println(stack)
    }

    private fun <T> insertAtBottom(stack: Stack<T>, item: T) {
        if (stack.isEmpty()) {
            stack.push(item)
            return
        }

        val topItem = stack.pop()
        insertAtBottom(stack, item)
        stack.push(topItem)
    }

    /*Given an array of positive integers nums and a positive integer target,
     return the minimal length of a subarray whose sum is greater than or equal to target.
     If there is no such subarray, return 0 instead.*/
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var sum = 0
        var minLength = Int.MAX_VALUE

        for (right in nums.indices) {
            sum += nums[right]  // Expand window

            // Shrink window from the left while sum is ≥ target
            while (sum >= target) {
                minLength = minOf(minLength, right - left + 1)
                sum -= nums[left]  // Shrink window
                left++
            }
        }

        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }

    fun minimumSizeSubArrayWithMaxSum(arr: IntArray) {

        val list = ArrayList<Int>()
        arr.sort()
        val sum = arr.sum()
        var temp = 0
        for (i in arr.size - 1 downTo 0) {
            if (temp > sum / 2) break
            list.add(arr[i])
            temp += arr[i]
        }

        print(list)
    }


    //"geeksforgeeks"
    fun longestUniqueSubstring(s: String): String {
        val charIndexMap = mutableMapOf<Char, Int>()
        var maxLength = 0
        var start = 0
        var maxStart = 0  // To track the start index of the longest substring

        for ((i, char) in s.withIndex()) {
            if (char in charIndexMap) {
                start = maxOf(start, charIndexMap[char]!! + 1)
            }
            charIndexMap[char] = i

            // Update maxLength and track the start of the longest substring
            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1
                maxStart = start
            }
        }
        println("Max length: $maxLength")
        println("Result: ${s.substring(maxStart, maxStart + maxLength)}")
        return s.substring(maxStart, maxStart + maxLength)
    }


    fun majorityElement(nums: IntArray) {
        val moreFrequent = nums.groupBy { it }.mapValues { it.value.size }.maxBy { it.value }
        println("More Frequent: $moreFrequent")
        val group = nums.groupBy { it }.mapValues { it.value.size }.filter { it.value > (nums.size / 2) }
        println(group)
    }

    fun productOfAllElementsExceptSelf(nums: IntArray): List<Int> {
        val n = nums.size
        val result = MutableList(n) { 1 }

        var leftProduct = 1
        for (i in nums.indices) {
            result[i] = leftProduct
            leftProduct *= nums[i]
        }

        var rightProduct = 1
        for (i in nums.indices.reversed()) {
            result[i] *= rightProduct
            rightProduct *= nums[i]
        }
        return result
    }
}