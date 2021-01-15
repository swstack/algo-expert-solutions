package algo.expert.solutions

import algo.expert.solutions.easy.isValidSubsequence
import algo.expert.solutions.easy.twoNumberSum
import kotlin.test.Test

class TestEasySolutions {
    @Test
    fun testTwoNumberSum() {
        twoNumberSum(mutableListOf(1, 5, 2, 4, 6, 8, 9), 6)
        twoNumberSum(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10)
    }

    @Test
    fun testValidateSubsequence() {
        isValidSubsequence(listOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(1, 6, -1, 10))
        isValidSubsequence(listOf(1, 2, 3, 4, 5), listOf(6, 7))
    }
}
