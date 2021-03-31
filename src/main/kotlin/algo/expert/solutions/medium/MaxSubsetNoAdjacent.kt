package algo.expert.solutions.medium

import java.lang.Integer.max

fun maxSubsetSumNoAdjacent(array: List<Int>): Int {
    if (array.isEmpty()) return 0
    if (array.size == 1) return array[0]
    if (array.size == 2) return max(array[0], array[1])

    val maxes = IntArray(array.size)
    maxes[0] = array[0]
    maxes[1] = max(array[0], array[1])

    for (i in 2 until array.size) {
        val prev1 = maxes[i - 1]
        val prev2 = maxes[i - 2]
        maxes[i] = max(prev1, prev2 + array[i])
    }

    return maxes.max()!!
}
