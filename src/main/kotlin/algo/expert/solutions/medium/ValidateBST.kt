package algo.expert.solutions.medium

import algo.expert.utils.BST

fun validateBst(tree: BST): Boolean {
    return helper(tree, Int.MIN_VALUE, Int.MAX_VALUE)
}


fun helper(tree: BST?, min: Int, max: Int): Boolean {
    // Each node has a minimum and maximum valid value:
    //   Left nodes have a minimum value of -infinity
    //   Left nodes have a maximum value of their parents value - 1
    //   Right nodes have a minimum value of their parent
    //   Right nodes have a maximum value of +infinity

    if(tree == null) return true

    if (tree.value > max || tree.value < min) {
        return false
    }

    var leftValid = helper(tree.left, min, tree.value - 1)
    var rightValid = helper(tree.right, tree.value, max)

    return leftValid && rightValid
}
