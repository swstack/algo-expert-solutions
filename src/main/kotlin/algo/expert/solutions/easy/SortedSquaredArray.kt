package algo.expert.solutions.easy

import kotlin.math.pow

fun sortedSquaredArray(array: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in array.indices) {
        val tmp = array[i]
        result.add(i, tmp.toDouble().pow(2).toInt())
    }
    return result.sorted()
}
