package algo.expert.solutions

import algo.expert.solutions.medium.*
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
        assertEquals(isMonotonic(listOf(1, 2, 3)), true)
        assertEquals(isMonotonic(listOf(-1, -5, -10, -1100, -900, -1101, -1102, -9001)), false)
        assertEquals(isMonotonic(listOf(1, 2, 0)), false)
    }

    @Test
    fun testSpiralTraverse() {
        val matrix = listOf(
            listOf(1, 2, 3, 4),
            listOf(12, 13, 14, 5),
            listOf(11, 16, 15, 6),
            listOf(10, 9, 8, 7)
        )
        val result = spiralTraverse(matrix)
        assertEquals(result, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16))

        val matrix2 = listOf(
            listOf(1, 2, 3, 4),
            listOf(8, 7, 6, 5)
        )
        val result2 = spiralTraverse(matrix2)
        assertEquals(result2, listOf(1, 2, 3, 4, 5, 6, 7, 8))

        assertEquals(spiralTraverse(listOf(listOf(1, 2, 3, 4))), listOf(1, 2, 3, 4))
        assertEquals(spiralTraverse(listOf(listOf(1), listOf(2), listOf(3), listOf(4))), listOf(1, 2, 3, 4))
    }
}
