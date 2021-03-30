package algo.expert.utils

import com.beust.klaxon.Klaxon

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = BST(value)
            } else {
                this.left!!.insert(value)
            }
        } else {

            if (this.right == null) {
                this.right = BST(value)
            } else {
                this.right!!.insert(value)
            }
        }
    }
}

fun loadBST(serialized: String): BST? {
    var bst: BST? = null
    var nodeMap = mutableMapOf<String, BST>()
    Klaxon().parse<JsonBST>(serialized)?.let { jsonBST ->
        for (node in jsonBST.nodes) {
            nodeMap[node.id] = BST(node.value)
        }

        for (node in jsonBST.nodes) {
            nodeMap[node.id]?.left = nodeMap[node.left]
            nodeMap[node.id]?.right = nodeMap[node.right]
        }

        bst = nodeMap[jsonBST.root]
    }

    return bst
}

class JsonBST(val nodes: List<JsonBSTNode>, val root: String)

class JsonBSTNode(val id: String, val left: String?, val right: String?, val value: Int)