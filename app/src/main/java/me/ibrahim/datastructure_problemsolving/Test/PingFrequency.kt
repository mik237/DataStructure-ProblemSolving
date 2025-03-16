package me.ibrahim.datastructure_problemsolving.Test

class PingFrequency {
    private val userPings = mutableMapOf<String, MutableList<Int>>()

    fun recordPing(userId: String, time: Int) {
        userPings.computeIfAbsent(userId) { mutableListOf() }.add(time)
    }

    fun getUserPingsPerInterval(userId: String, freq: String, startTime: Int, endTime: Int): List<Int> {
        val intervals = when (freq) {
            "minute" -> 60
            "hour" -> 3600
            "day" -> 86400
            else -> throw IllegalArgumentException("Invalid frequency")
        }

        val result = MutableList(((endTime - startTime) / intervals) + 1) { 0 }
        val userPingTimes = userPings[userId] ?: return result

        for (ping in userPingTimes) {
            if (ping in startTime..endTime) {
                val index = (ping - startTime) / intervals
                result[index]++
            }
        }

        return result
    }
}

fun main() {
    val pf = PingFrequency()
    pf.recordPing("user_1", 5)
    pf.recordPing("user_2", 15)
    pf.recordPing("user_2", 20)
    pf.recordPing("user_1", 90)
    pf.recordPing("user_3", 100)
    pf.recordPing("user_1", 110)
    pf.recordPing("user_3", 120)
    pf.recordPing("user_3", 170)
    pf.recordPing("user_2", 2500)
    pf.recordPing("user_3", 3600)
    pf.recordPing("user_3", 3800)

    println(pf.getUserPingsPerInterval("user_1", "minute", 0, 150)) // Output: [1, 2, 0]
    println(pf.getUserPingsPerInterval("user_3", "hour", 10, 4000)) // Output: [4, 1]
}