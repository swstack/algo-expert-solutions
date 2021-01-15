package algo.expert.solutions.easy

import java.lang.Math.abs
import java.util.Stack

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun findClosestValueInBst(tree: BST, target: Int): Int {
    var stack = Stack<BST>()
    stack.push(tree)

    var closest = tree.value
    while (!stack.isEmpty()) {
        var next = stack.pop()
        if (next.left != null) {
            stack.push(next.left)
        }
        if (next.right != null) {
            stack.push(next.right)
        }

        if (abs(next.value - target) < abs(closest - target)) {
            closest = next.value
        }
    }

    return closest
}
