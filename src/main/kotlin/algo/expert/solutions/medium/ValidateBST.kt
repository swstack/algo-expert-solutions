package algo.expert.solutions.medium

fun validateBst(tree: BST): Boolean {
    return helper(tree, Int.MIN_VALUE, Int.MAX_VALUE)
}


fun helper(tree: BST?, min: Int, max: Int): Boolean {

    if(tree == null) return true

    if (tree.value > max || tree.value < min) {
        return false
    }

    var leftValid = helper(tree.left, min, tree.value - 1)
    var rightValid = helper(tree.right, tree.value, max)

    return leftValid && rightValid
}
