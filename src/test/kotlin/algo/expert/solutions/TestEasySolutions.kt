package algo.expert.solutions

import algo.expert.solutions.easy.branchSums
import algo.expert.solutions.easy.isValidSubsequence
import algo.expert.solutions.easy.nodeDepths
import algo.expert.solutions.easy.twoNumberSum
import algo.expert.utils.TreeNode
import algo.expert.utils.load
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

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

    @Test
    fun testBranchSums() {
        val jsonTree = """
        {
          "nodes": [
            {"id": "1", "left": "2", "right": "3", "value": 1},
            {"id": "2", "left": "4", "right": "5", "value": 2},
            {"id": "3", "left": "6", "right": "7", "value": 3},
            {"id": "4", "left": "8", "right": "9", "value": 4},
            {"id": "5", "left": "10", "right": null, "value": 5},
            {"id": "6", "left": null, "right": null, "value": 6},
            {"id": "7", "left": null, "right": null, "value": 7},
            {"id": "8", "left": null, "right": null, "value": 8},
            {"id": "9", "left": null, "right": null, "value": 9},
            {"id": "10", "left": null, "right": null, "value": 10}
          ],
          "root": "1"
        }"""

        val tree = load(jsonTree)
        assertNotNull(tree)
        val result = branchSums(tree)
        println(result)
    }

    @Test
    fun testNodeDepths() {
        val jsonTree = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": "3", "value": 1},
                {"id": "2", "left": "4", "right": "5", "value": 2},
                {"id": "3", "left": "6", "right": "7", "value": 3},
                {"id": "4", "left": "8", "right": "9", "value": 4},
                {"id": "5", "left": "10", "right": null, "value": 5},
                {"id": "6", "left": null, "right": null, "value": 6},
                {"id": "7", "left": null, "right": null, "value": 7},
                {"id": "8", "left": null, "right": null, "value": 8},
                {"id": "9", "left": null, "right": null, "value": 9},
              ],
              "root": "1"
            }
        """

        val tree = load(jsonTree)
        assertNotNull(tree)
        val result = nodeDepths(tree)
        println(result)
    }
}
