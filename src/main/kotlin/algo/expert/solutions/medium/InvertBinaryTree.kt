package algo.expert.solutions.medium

import algo.expert.utils.TreeNode as BinaryTree

fun invertBinaryTree(tree: BinaryTree) {
    val tmp = tree.right
    tree.right = tree.left
    tree.left = tmp
    tree.left?.let { left ->
        invertBinaryTree(left)
    }
    tree.right?.let { right ->
        invertBinaryTree(right)
    }
}
