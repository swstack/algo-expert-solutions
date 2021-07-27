package algo.expert.solutions

import algo.expert.solutions.medium.*
import algo.expert.utils.BST
import algo.expert.utils.loadBST
import org.junit.Test
import kotlin.test.assertEquals
import algo.expert.solutions.medium.BST as BSTConstruction

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
//        assertEquals(longestPeak(listOf(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3)), 6)
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
        var bst = BSTConstruction(10)
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
        var bst = BSTConstruction(10)
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
        val valid = validateBst(bst)
        assert(valid)

        val bst2 = BST(10)
        bst2.left = BST(15)
        bst2.right = BST(5)
        val valid2 = validateBst(bst2)
        assert(!valid2)
    }

    @Test
    fun testBSTTraversal() {
        var bst = BST(10)
        bst.insert(5)
        bst.insert(15)
        assertEquals(inOrderTraverse(bst, mutableListOf()), listOf(5, 10, 15))
        assertEquals(preOrderTraverse(bst, mutableListOf()), listOf(10, 5, 15))
        assertEquals(postOrderTraverse(bst, mutableListOf()), listOf(5, 15, 10))
        assertEquals(reverseInOrderTraverse(bst, mutableListOf()), listOf(15, 10, 5))
    }

    @Test
    fun testMinHeightBST() {
        val bst = minHeightBst(listOf(1, 2, 5, 7, 10, 13, 14, 15, 22))
        assertEquals(bst.value, 10)
    }

    @Test
    fun testKthLargestValueBST() {
        val json = """
        {
            "nodes": [
                {"id": "15", "left": "5", "right": "20", "value": 15},
                {"id": "20", "left": "17", "right": "22", "value": 20},
                {"id": "22", "left": null, "right": null, "value": 22},
                {"id": "17", "left": null, "right": null, "value": 17},
                {"id": "5", "left": "2", "right": "5-2", "value": 5},
                {"id": "5-2", "left": null, "right": null, "value": 5},
                {"id": "2", "left": "1", "right": "3", "value": 2},
                {"id": "3", "left": null, "right": null, "value": 3},
                {"id": "1", "left": null, "right": null, "value": 1}
            ],
            "root": "15"
        }
        """
        val bst = loadBST(json)
        assertEquals(findKthLargestValueInBst(bst!!, 3), 17)
    }

    @Test
    fun testWaysToMakeChange() {
        assertEquals(numberOfWaysToMakeChange(10, listOf(2, 5, 10, 25)), 3)
    }

    @Test
    fun testMinCoinsForChange() {
        assertEquals(minNumberOfCoinsForChange(7, listOf(1, 5, 10)), 3)
        assertEquals(minNumberOfCoinsForChange(10, listOf(1, 3, 4)), 3)
        assertEquals(minNumberOfCoinsForChange(9, listOf(3, 5)), 3)

        assertEquals(minNumberOfCoinsForChangeTreeNaive(7, listOf(1, 5, 10)), 3)
        assertEquals(minNumberOfCoinsForChangeTreeNaive(10, listOf(1, 3, 4)), 3)
        assertEquals(minNumberOfCoinsForChangeTreeNaive(9, listOf(3, 5)), 3)

        // This test case OOM's
        // assertEquals(minNumberOfCoinsForChangeTreeNaive(150, listOf(1, 5, 10, 7, 8, 9)), 3)

        assertEquals(minNumberOfCoinsForChangeTreeOptimized(7, listOf(1, 5, 10)), 3)
        assertEquals(minNumberOfCoinsForChangeTreeOptimized(10, listOf(1, 3, 4)), 3)
        assertEquals(minNumberOfCoinsForChangeTreeOptimized(9, listOf(3, 5)), 3)
        // This test case OOM's
//        assertEquals(minNumberOfCoinsForChangeTreeOptimized(150, listOf(1, 5, 10, 7, 8, 9)), 3)
    }

    @Test
    fun maxSubsetNoAdjacent() {
        assertEquals(maxSubsetSumNoAdjacent(listOf(75, 105, 120, 75, 90, 135)), 330)
    }

    @Test
    fun testWaysToTraverseGraph() {
        assertEquals(numberOfWaysToTraverseGraph(4, 3), 10)
    }

    @Test
    fun testSingleCycleCheck() {
        assertEquals(hasSingleCycle(listOf(1, 1, 1, 1, 2)), false)
        assertEquals(hasSingleCycle(listOf(2, 3, 1, -4, -4, 2)), true)
        assertEquals(hasSingleCycle(listOf(2, -7, 11, -2, 1)), true)
    }

    @Test
    fun testPermutations() {
        Permutations.getPermutations(listOf(1, 2, 3))
    }

    @Test
    fun testPhoneNumberMnemonics() {
        PhoneNumberMnemonics().phoneNumberMnemonics("123")
    }

}
