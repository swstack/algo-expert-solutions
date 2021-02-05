package algo.expert.solutions

import algo.expert.solutions.easy.*
import algo.expert.utils.loadSLL
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

    @Test
    fun testBinarySearch() {
        var result = binarySearch(listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 33)
        assertEquals(result, 3)

        var result2 = binarySearch(listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 0)
        assertEquals(result2, 0)
    }

    @Test
    fun testMinimumWaitingTime() {
        assertEquals(minimumWaitingTime(mutableListOf(3, 2, 1, 2, 6)), 17)
        assertEquals(minimumWaitingTimeBruteForce(mutableListOf(3, 2, 1, 2, 6)), 17)
    }

    @Test
    fun testFindThreeLargestNumbers() {
        val result = findThreeLargestNumbers(listOf(141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7))
        assertEquals(result, listOf(18, 141, 541))
    }

    @Test
    fun testBubbleSort() {
        assertEquals(bubbleSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)), mutableListOf(2, 3, 5, 5, 6, 8, 9))
    }

    @Test
    fun testInsertionSort() {
        assertEquals(insertionSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)), mutableListOf(2, 3, 5, 5, 6, 8, 9))
    }

    @Test
    fun testSelectionSort() {
        assertEquals(selectionSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)), mutableListOf(2, 3, 5, 5, 6, 8, 9))
    }

    @Test
    fun testIsPalindrome() {
        assertEquals(isPalindrome("abcdcba"), true)
    }

    @Test
    fun testCaesarCipherEncryptor() {
        assertEquals(caesarCipherEncryptor("xyz", 2), "zab")
        assertEquals(caesarCipherEncryptor("abc", 52), "abc")
    }

    @Test
    fun testRunLengthEncoding() {
        assertEquals(runLengthEncoding("aaabbb"), "3a3b")
        assertEquals(runLengthEncoding("aaaaaaaaaaaabbb"), "9a3a3b")
    }

    @org.junit.Test
    fun testRemoveDuplicatesFromLL() {
        val json = """
            {
                "head": "1",
                "nodes": [
                  {"id": "1", "next": "1-2", "value": 1},
                  {"id": "1-2", "next": "1-3", "value": 1},
                  {"id": "1-3", "next": "2", "value": 1},
                  {"id": "2", "next": "3", "value": 3},
                  {"id": "3", "next": "3-2", "value": 4},
                  {"id": "3-2", "next": "3-3", "value": 4},
                  {"id": "3-3", "next": "4", "value": 4},
                  {"id": "4", "next": "5", "value": 5},
                  {"id": "5", "next": "5-2", "value": 6},
                  {"id": "5-2", "next": null, "value": 6}
                ]
            }
        """.trimIndent()

        val sll = loadSLL(json)
        assertNotNull(sll)
        removeDuplicatesFromLinkedList(sll)
    }
}
