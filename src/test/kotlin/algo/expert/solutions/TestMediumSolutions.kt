package algo.expert.solutions

import algo.expert.solutions.medium.isMonotonic
import algo.expert.solutions.medium.moveElementToEnd
import algo.expert.solutions.medium.smallestDifference
import algo.expert.solutions.medium.threeNumberSum
import org.junit.Test
import kotlin.test.assertEquals

class TestMediumSolutions {
    @Test
    fun testThreeNumberSum() {
        threeNumberSum(mutableListOf(1, 2, 3), 0)
        threeNumberSum(mutableListOf(12, 3, 1, 2, -6, 5, -8, 6), 0)
    }

    @Test
    fun testSmallestDifference() {
        smallestDifference(mutableListOf(-1, 5, 10, 20, 28, 3), mutableListOf(26, 134, 135, 15, 17))
    }

    @Test
    fun testMoveElementToEnd() {
        var result = moveElementToEnd(mutableListOf(2, 1, 2, 2, 2, 3, 4, 2), 2)
        assertEquals(result, listOf(1, 3, 4, 2, 2, 2, 2, 2))
    }

    @Test
    fun testMonotonicArray() {
//        assertEquals(isMonotonic(listOf(1, 2, 3)), true)
//        assertEquals(isMonotonic(listOf(-1, -5, -10, -1100, -900, -1101, -1102, -9001)), false)
        assertEquals(isMonotonic(listOf(1, 2, 0)), false)
    }
}
