package algo.expert.solutions.easy

import algo.expert.utils.TreeNode as BinaryTree

fun nodeDepths(root: BinaryTree): Int {
    return nodeDepthsRecursive(root, 0)
}

fun nodeDepthsRecursive(root: BinaryTree, depth: Int): Int {
    if (root.left == null && root.right == null) {
        return depth
    }

    var leftDepths = 0
    root.left?.let { left ->
        leftDepths = nodeDepthsRecursive(left, depth + 1)
    }

    var rightDepths = 0
    root.right?.let { right ->
        rightDepths = nodeDepthsRecursive(right, depth + 1)
    }

    return leftDepths + rightDepths + depth
}
