package algo.expert.solutions.medium

import algo.expert.utils.BST

fun findKthLargestValueInBst(tree: BST, k: Int): Int {
    // Perform reverse in order traversal

    val elems = reverseInOrderTraverse(tree, mutableListOf(), k)
    return elems.last()
}

private fun reverseInOrderTraverse(tree: BST, array: MutableList<Int>, k: Int): List<Int> {
    if (array.size == k) {
        return array
    }

    if (tree.right != null) {
        reverseInOrderTraverse(tree.right!!, array, k)
        if (array.size == k) {
            return array
        }
    }

    array.add(tree.value)

    if (tree.left != null) {
        reverseInOrderTraverse(tree.left!!, array, k)
    }

    return array
}