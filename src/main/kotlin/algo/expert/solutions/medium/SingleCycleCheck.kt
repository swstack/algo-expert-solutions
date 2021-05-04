package algo.expert.solutions.medium

import kotlin.math.abs

fun hasSingleCycle(array: List<Int>): Boolean {
    val visited = mutableListOf<Int>()
    val lastIndex = recursiveHelper(0, array, visited)
    return array.size == visited.size && lastIndex == 0
}

private fun recursiveHelper(curr: Int, graph: List<Int>, visited: MutableList<Int>): Int {
    if (visited.contains(curr)) return curr
    visited.add(curr)

    val jump = graph[curr]

    val next = when {
        jump > 0 -> {
            // Forwards
             val jumpIdx = curr + (jump % graph.size)
            if (jumpIdx >= graph.size) {
                jumpIdx - graph.size
            } else {
                jumpIdx
            }
        }
        jump < 0 -> {
            // Backwards
            val jumpIdx = curr - (abs(jump) % graph.size)
            if (jumpIdx < 0) {
                graph.size + jumpIdx
            } else {
                jumpIdx
            }
        } else -> {
            // No jump
            curr
        }
    }

    return recursiveHelper(next, graph, visited)
}