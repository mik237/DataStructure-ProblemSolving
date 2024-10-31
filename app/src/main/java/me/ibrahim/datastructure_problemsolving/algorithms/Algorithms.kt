package me.ibrahim.datastructure_problemsolving.algorithms


fun main() {
    Algorithms.findFirstNonRepeatedChar("goubemhkhgbvdkhoiubdkhkvfkhweiugdkjvhdskfhskbksfdwoeu")
}

object Algorithms {
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
}