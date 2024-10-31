package me.ibrahim.datastructure_problemsolving.algorithms


fun main() {
//    Algorithms.findFirstNonRepeatedChar("goubemhkhgbvdkhoiubdkhkvfkhweiugdkjvhdskfhskbksfdwoeu")

//    Algorithms.areAnagrams("listen", "silent")

    Algorithms.mostFrequentElement(intArrayOf(1, 2, 3, 4, 5, 4, 3, 5, 6, 10, 4, 3, 6, 7, 1, 0, 4))
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
}