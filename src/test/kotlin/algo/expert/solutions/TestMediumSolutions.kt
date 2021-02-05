package algo.expert.solutions

import algo.expert.solutions.medium.threeNumberSum
import org.junit.Test
import kotlin.test.assertEquals

class TestMediumSolutions {
    @Test
    fun testThreeNumberSum() {
        threeNumberSum(mutableListOf(1, 2, 3), 0)
        threeNumberSum(mutableListOf(12, 3, 1, 2, -6, 5, -8, 6), 0)
    }
}
