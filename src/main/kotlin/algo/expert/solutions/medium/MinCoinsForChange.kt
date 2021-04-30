package algo.expert.solutions.medium

import java.lang.Integer.min


// Solution: Dynamic programming
fun minNumberOfCoinsForChange(n: Int, denoms: List<Int>): Int {
    val coins = IntArray(n + 1) { -1 }
    coins[0] = 0
    for (d in denoms.sorted()) {
        for (i in 1 until coins.size) {
            if (d <= i) {
                val remaining = i - d
                val remainingCoins = coins[remaining]
                if (remainingCoins != -1) {
                    if (coins[i] == -1) {
                        coins[i] = 1 + remainingCoins
                    } else {
                        coins[i] = min(coins[i], 1 + remainingCoins)
                    }
                }
            }
        }
    }
    return coins[n]
}


// Solution: Build a tree of all possible combinations -- very inefficient
class TreeNode(var value: Int) {
    var children: MutableList<TreeNode> = mutableListOf()
}

fun minNumberOfCoinsForChangeTreeNaive(n: Int, denoms: List<Int>): Int {
    val root = buildTree(TreeNode(n), denoms)
    val shortest = findShortestBranchEqualToZero(root, 0)
    return shortest
}


fun buildTree(node: TreeNode, denoms: List<Int>): TreeNode {
    for (d in denoms) {
        if (node.value - d >= 0) {
            node.children.add(TreeNode(node.value - d))
        }
    }

    for (c in node.children) {
        buildTree(c, denoms)
    }

    return node
}

fun findShortestBranchEqualToZero(node: TreeNode, depth: Int): Int {
    if (node.value == 0) {
        return depth
    }

    if (node.children.isEmpty()) {
        return Integer.MAX_VALUE
    }

    val lengths = mutableListOf<Int>()
    for (c in node.children) {
        lengths.add(findShortestBranchEqualToZero(c, depth + 1))
    }

    return lengths.min()!!
}

// Solution: Build optimized tree (without using actual tree data structure)
// - Build out the tree breadth-first
// - Stop on the first branch to equal 0 instead of building out the entire tree
// - Stop building branches < 0

fun minNumberOfCoinsForChangeTreeOptimized(n: Int, denoms: List<Int>): Int {
    return treeOptimizedHelper(listOf(n), denoms, 1)
}

fun treeOptimizedHelper(row: List<Int>, denoms: List<Int>, depth: Int): Int {

    if (row.isEmpty()) {
        return Integer.MAX_VALUE
    }

    val nextRow = mutableListOf<Int>()
    for (node in row) {
        for (d in denoms) {
            if (node - d == 0) {
                return depth
            }
            if (node - d > 0) {
                nextRow.add(node - d)
            }
        }
    }

    return treeOptimizedHelper(nextRow, denoms, depth + 1)
}