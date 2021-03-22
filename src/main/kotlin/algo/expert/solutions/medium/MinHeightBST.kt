package algo.expert.solutions.medium

import algo.expert.utils.BST

fun minHeightBst(array: List<Int>): BST {
    // The input array is sorted. Select each node to insert in an order
    // that guarantees the tree is balanced (left tree has same number of nodes as right)

    // Algo: First node to insert is the middle of the array, then take each half of
    // the array and select the middle of each array to insert into the tree

    val middleVal = array[array.size / 2]
    var bst = BST(middleVal)

    val left = array.subList(0, array.size / 2)
    val right = array.subList(array.size / 2 + 1, array.size)

    if (left.isNotEmpty()) {
        bst.left = minHeightBst(left)
    }
    if (right.isNotEmpty()) {
        bst.right = minHeightBst(right)
    }
    
    return bst
}
