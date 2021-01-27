package algo.expert.solutions.easy

fun minimumWaitingTime(queries: MutableList<Int>): Int {
    // Sort ascending
    queries.sort()

    // TODO: More efficient solution

    return minimumWaitingTimeBruteForce(queries)

}

fun minimumWaitingTimeBruteForce(queries: MutableList<Int>): Int {
    // Sort ascending
    queries.sort()

    var waitingTime = 0
    for (i in 0 until queries.size) {
        if (i == 0) {
            continue
        }
        for (j in 0 until i) {
            waitingTime += queries[j]
        }
    }

    return waitingTime
}