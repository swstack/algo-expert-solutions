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

    @Test
    fun testLongestPeak() {
        assertEquals(longestPeak(listOf(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3)), 6)
    }

    @Test
    fun testArrayOfProducts() {
        assertEquals(arrayOfProducts(listOf(5, 1, 4, 2)), listOf(8, 40, 10, 20))
    }

    @Test
    fun testFirstDuplicateValue() {
        assertEquals(firstDuplicateValue(mutableListOf(2, 1, 5, 2, 3, 3, 4)), 2)
        assertEquals(firstDuplicateValue(mutableListOf(2, 1, 5, 3, 3, 2, 4)), 3)
        assertEquals(firstDuplicateValue(mutableListOf()), -1)
    }

    @Test
    fun testBSTConstruction() {
        var bst = BST(10)
        assertEquals(bst.contains(5), false)
        bst.insert(5)
        assertEquals(bst.contains(5), true)
        bst.insert(15)
        bst.insert(7)
        assertEquals(bst.contains(7), true)
        bst.remove(7)
        assertEquals(bst.contains(7), false)
        bst.remove(10)
        assert(!bst.contains(10))
    }

    @Test
    fun testBSTConstruction2() {
        var bst = BST(10)
        bst = bst.insert(5)
        bst = bst.insert(15)
        bst = bst.remove(10)
        assertEquals(bst.value, 15)
        assert(bst.right == null)
    }

    @Test
    fun testValidateBST() {
        val bst = BST(10)
        bst.left = BST(5)
        bst.right = BST(15)
        assert(validateBst(bst))

        val bst2 = BST(10)
        bst.left = BST(15)
        bst.right = BST(5)
        assert(!validateBst(bst))
    }
}
