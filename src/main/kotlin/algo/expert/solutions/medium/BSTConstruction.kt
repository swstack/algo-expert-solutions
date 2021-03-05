package algo.expert.solutions.medium

// Do not edit the class below except for
// the insert, contains, and remove methods.
// Feel free to add new properties and methods
// to the class.
open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int): BST {
        recursiveInsert(this, value)
        return this
    }

    fun contains(value: Int): Boolean {
        return recursiveFind(this, value) != null
    }

    fun remove(value: Int): BST {
        recursiveDelete(this, value)
        return this
    }

    private fun recursiveFind(root: BST, value: Int): BST? {
        if (root.value == value) {
            return root
        }

        if (value <= root.value && root.left != null) {
            return recursiveFind(root.left!!, value)
        }

        if (value > root.value && root.right != null) {
            return recursiveFind(root.right!!, value)
        }

        return null
    }

    private fun recursiveInsert(root: BST?, value: Int): BST? {
        if (root == null) {
            return BST(value)
        }

        if (value < root.value) {
            val newNode = recursiveInsert(root.left, value)
            if (newNode != null) {
                root.left = newNode
            }
        } else {
            val newNode = recursiveInsert(root.right, value)
            if (newNode != null) {
                root.right = newNode
            }
        }

        return root
    }

    private fun recursiveDelete(root: BST, value: Int): BST? {
        if (root.value == value) {
            if (root.left == null && root.right == null) {
                // No children
                return null
            } else if (root.left != null && root.right == null) {
                // One child to the left
                root.value = root.left!!.value
                root.left = root.left?.left
                root.right = root.left?.right
                return root
            } else if (root.left == null && root.right != null) {
                // One child to the right
                root.value = root.right!!.value
                root.left = root.right?.left
                root.right = root.right?.right
                return root
            } else {
                // Two children
                // Find the minimum value in the right subtree to swap
                // with the current node. It is guaranteed to be a leaf
                // node and be greater than the entire left tree
                val minNode = findMinimumNodeInSubtree(root.right!!)

                // Call self to delete the minNode
                root.right = recursiveDelete(root.right!!, minNode.value)

                // Return modified tree
                root.value = minNode.value
                return root
            }
        }

        if (value < root.value && root.left != null) {
            root.left = recursiveDelete(root.left!!, value)
        }

        if (value >= root.value && root.right != null) {
            root.right = recursiveDelete(root.right!!, value)
        }

        return root
    }

    private fun findMinimumNodeInSubtree(root: BST): BST {
        // Minimum value in a BST is always the farthest left leaf node
        return if (root.left != null) {
            findMinimumNodeInSubtree(root.left!!)
        } else {
            root
        }
    }
}