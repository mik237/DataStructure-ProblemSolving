package me.ibrahim.datastructure_problemsolving.Test

/*
* // When booting the Intercom messenger on any website we make a request to the "ping" endpoint with the user credentials.
// We want to analyse the number of requests per user to this endpoint in select periods of time.
// These periods are partitioned into smaller chunks based on a certain frequency (minute/hour/day).

// You have to design and implement the following API:
// Class: PingFrequency
// Function: void recordPing(<string> userId, <integer> Time)
// Function: List<Integer> getUserPingsPerInterval(<string> userId, <string> freq, <integer> startTime, <integer> endTime)

// Example:

// INPUT
// recordPing("user_1", 5)
// recordPing("user_2", 15)
// recordPing("user_2", 20)
// recordPing("user_1", 90)
// recordPing("user_3", 100)
// recordPing("user_1", 110)
// recordPing("user_3", 120)
// recordPing("user_3", 170)
// recordPing("user_2", 2500)
// recordPing("user_3", 3600)
// recordPing("user_3", 3800)

// INPUT - getUserPingsPerInterval("user_1", "minute", 0, 150)
// OUTPUT - [1, 2, 0]

// Explanation: This is partitioned into [0-59, 60-119, 120-150]
// Within the 0-59 window, the user pinged once.
// Within the 60-119 window, the user pinged twice.
// They made no request in the last window.
// This leads to a final result of: [1, 2, 0]

// INPUT - getUserPingsPerInterval("user_3", "hour", 10, 4000)
// OUTPUT - [4, 1]

// Explanation: This is partitioned into [10-3609, 3610-4000]
// Within the 10-3609 window, the user pinged 4 times.
// Within the 3610-4000 window, they pinged once.
// This leads to the final result of: [4, 1]


val pingTimeByUser = mutableMapOf<String, MutableList<Int>>()

fun recordPing(userId: String, time: Int){

    pingTimeByUser[userId] = (pingTimeByUser[userId] ?: mutableListOf<Int>()).add(time)

}

fun getUserPingsPerInterval(userId: String, freq: String, startTime: Int, endTime: Int): List<Int>{

    val pingRecords = pingTimeByUser[userId] ?: emptyList()
    val startTimeUpdate = conertIntervalToSeconds(freq) + startTime - 1


    pingRecords.forEach{

    }
}

private fun conertIntervalToSeconds(freq: String): Int{

    when(freq){
    "hour" -> 60*60
    "minute" -> 60
    "day" -> 24*60*60

    }
}

*/
fun main() {
    recordPing("user_1", 5)
    recordPing("user_2", 15)
    recordPing("user_2", 20)
    recordPing("user_1", 90)
    recordPing("user_3", 100)
    recordPing("user_1", 110)
    recordPing("user_3", 120)
    recordPing("user_3", 170)
    recordPing("user_2", 2500)
    recordPing("user_3", 3600)
    recordPing("user_3", 3800)

    val output = getUserPingsPerInterval("user_3", "hour", 10, 4000)

    println(output)
}


val pingTimeByUser = mutableMapOf<String, MutableList<Int>>()

fun recordPing(userId: String, time: Int) {
    val pingList = pingTimeByUser[userId]
    if (pingList != null) {
        pingList.add(time)
    } else {
        pingTimeByUser[userId] = mutableListOf(time)
    }
}

fun getUserPingsPerInterval(userId: String, freq: String, startTime: Int, endTime: Int): List<Int> {

    val pingRecords = pingTimeByUser[userId] ?: return emptyList()

    val userPingsInterval = mutableMapOf<Int, Int>()

    var startTimeInterval = startTime
    var endTimeInterval = conertIntervalToSeconds(freq) + startTime - 1

    var intervalCount = 1

    pingRecords.forEach {
        if (it in startTimeInterval..endTimeInterval) {
            userPingsInterval[intervalCount] = (userPingsInterval[intervalCount] ?: 0) + 1
        } else if (it > endTimeInterval) {
            startTimeInterval = endTimeInterval + 1
            endTimeInterval *= 2
            intervalCount++
            userPingsInterval[intervalCount] = (userPingsInterval[intervalCount] ?: 0) + 1
        }
    }

    return userPingsInterval.values.toList()
}

private fun conertIntervalToSeconds(freq: String): Int {

    val freq = when (freq) {
        "hour" -> 60 * 60
        "minute" -> 60
        "day" -> 24 * 60 * 60
        else -> 0
    }
    return freq
}