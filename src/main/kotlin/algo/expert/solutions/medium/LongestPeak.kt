package algo.expert.solutions.medium


fun longestPeak(array: List<Int>): Int {
    // TODO: Doesn't work

    if (array.size < 4) {
        return -1
    }

    var increasingCount = 0
    var decreasingCount = 0
    var currentPeak = 0
    var longestPeak = 0
    for (i in 1 until array.size) {
        val last = array[i - 1]
        val current = array[i]
        val newDirection = current - last

        // Positive int means "increasing"
        if (newDirection >= 0) {
            increasingCount++
            currentPeak += decreasingCount
            decreasingCount = 0

            if (currentPeak >= longestPeak) {
                longestPeak = currentPeak
            }

            currentPeak = 0
        } else {
            currentPeak += increasingCount
            decreasingCount++

//            if (increasingCount >= 1) {
//                if (increasingCount >= longestPeak) {
//                    longestPeak = increasingCount
//                }
//            }
//
            increasingCount = 0
        }
    }

    return longestPeak
}
