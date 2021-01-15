package algo.expert.solutions.easy

import java.util.*

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun branchSums(root: BinaryTree): List<Int> {
    var stack = Stack<BinaryTree>()
    stack.push(root)

    var sums = listOf<Int>()
    while (!stack.isEmpty()) {
        var next = stack.pop()
        if (next.left != null) {
            stack.push(next.left)
        }

        if (next.right != null) {
            stack.push(next.right)
        }

        println(next.value)
    }

    return listOf()
}


