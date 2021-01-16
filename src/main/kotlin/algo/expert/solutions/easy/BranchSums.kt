package algo.expert.solutions.easy

import algo.expert.utils.TreeNode as BinaryTree

fun branchSums(root: BinaryTree): List<Int> {
    return branchSumsRecursive(root, mutableListOf())
}

fun branchSumsRecursive(root: BinaryTree, sums: MutableList<Int>): List<Int> {
    val sumsInner: MutableList<Int> = if (sums.size == 0) {
        mutableListOf(root.value)
    } else {
        sums.map { it + root.value }.toMutableList()
    }

    if (root.left == null && root.right == null) {
        return sumsInner
    }

    var leftSums = listOf<Int>()
    root.left?.let { left ->
        leftSums = branchSumsRecursive(left, sumsInner)
    }

    var rightSums = listOf<Int>()
    root.right?.let { right ->
        rightSums = branchSumsRecursive(right, sumsInner)
    }

    return leftSums + rightSums
}
