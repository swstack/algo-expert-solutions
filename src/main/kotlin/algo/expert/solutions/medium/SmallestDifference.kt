package algo.expert.solutions.medium

import kotlin.math.abs
import kotlin.math.absoluteValue

fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    var result = mutableListOf<Int>()
    var smallestAbsoluteDiff: Int? = null
    for (a1 in arrayOne) {
        for (a2 in arrayTwo) {
            var absDiff: Int
            if ((a1 > 0 && a2 > 0) || (a1 < 0 && a2 < 0)) {
                // a1 and a2 are both positive, or both negative
                absDiff = abs(a1.absoluteValue - a2.absoluteValue)
            } else {
                // one is negative, one is positive
                absDiff = abs(a1 - a2)
            }

            if (smallestAbsoluteDiff == null) {
                smallestAbsoluteDiff = absDiff
                result.clear()
                result.add(a1)
                result.add(a2)
            } else {
                if (absDiff < smallestAbsoluteDiff) {
                    smallestAbsoluteDiff = absDiff
                    result.clear()
                    result.add(a1)
                    result.add(a2)
                }
            }
        }
    }
    return result
}
