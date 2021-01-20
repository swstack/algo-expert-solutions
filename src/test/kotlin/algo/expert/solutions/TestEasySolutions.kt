package algo.expert.solutions

import algo.expert.solutions.easy.*
import algo.expert.utils.loadTree
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

        val tree = loadTree(jsonTree)
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

        val tree = loadTree(jsonTree)
        assertNotNull(tree)
        val result = nodeDepths(tree)
        println(result)
    }

    @Test
    fun testDepthFirstSearch() {
        var a = Node("A")
        var b = Node("B")
        var c = Node("C")
        var d = Node("D")

        a.children.add(b)
        a.children.add(c)
        b.children.add(d)
        d.children.add(a)

        a.depthFirstSearch()
    }

    @Test
    fun testNthFib() {
        assertEquals(getNthFib(4), 3)
        assertEquals(getNthFib(10), 55)
    }

    @Test
    fun testProductSum() {
        var sum1 = productSum(listOf(1, 2, 3))
        assertEquals(sum1, 6)

        var sum2 = productSum(listOf(1, 2, listOf(1, 2)))
        assertEquals(sum2, 9)

        var sum3 = productSum(listOf(5, 2, listOf(7, -1), 3, listOf(6, listOf(-13, 8), 4)))
        assertEquals(sum3, 12)

        var sum4 = productSum(listOf(5, 2, listOf(-7, -1), 3))
        assertEquals(sum4, -6)
    }
}
