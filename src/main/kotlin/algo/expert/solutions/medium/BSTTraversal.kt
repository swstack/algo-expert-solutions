package algo.expert.solutions.medium


fun inOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    if (tree.left != null) {
        inOrderTraverse(tree.left!!, array)
    }

    array.add(tree.value)

    if (tree.right != null) {
        inOrderTraverse(tree.right!!, array)
    }

    return array
}

fun preOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    array.add(tree.value)

    if (tree.left != null) {
        preOrderTraverse(tree.left!!, array)
    }

    if (tree.right != null) {
        preOrderTraverse(tree.right!!, array)
    }

    return array
}

fun postOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    if (tree.left != null) {
        postOrderTraverse(tree.left!!, array)
    }

    if (tree.right != null) {
        postOrderTraverse(tree.right!!, array)
    }

    array.add(tree.value)

    return array
}
