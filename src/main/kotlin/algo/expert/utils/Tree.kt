package algo.expert.utils

import com.beust.klaxon.Klaxon

/*
Load tree given a json object:

{
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": "6", "right": "7", "value": 3},
      {"id": "4", "left": "8", "right": "9", "value": 4},
      {"id": "5", "left": "10", "right": null, "value": 5},
      {"id": "6", "left": null, "right": null, "value": 6},
      {"id": "7", "left": null, "right": null, "value": 7},
      {"id": "8", "left": null, "right": null, "value": 8},
      {"id": "9", "left": null, "right": null, "value": 9},
      {"id": "10", "left": null, "right": null, "value": 10}
    ],
    "root": "1"
}
 */
fun load(jsonTreeSerialized: String): TreeNode? {

    var tree: TreeNode? = null
    Klaxon().parse<JsonTree>(jsonTreeSerialized)?.let { jsonTree ->

        // Populate hashmap of value:TreeNode
        val nodesMap = mutableMapOf<Int, TreeNode>()
        for (node in jsonTree.nodes) {
            val treeNode = TreeNode(node.value)
            treeNode.id = node.id
            nodesMap[node.value] = treeNode
        }

        // Connect the nodes
        for (node in jsonTree.nodes) {
            nodesMap[node.value]?.let { root ->
                node.left?.let { left ->
                    root.left = nodesMap[left.toInt()]
                }
                node.right?.let { right ->
                    root.right = nodesMap[right.toInt()]
                }
            }
        }

        tree = nodesMap[jsonTree.root.toInt()]
    }

    return tree
}

class JsonTree(val nodes: List<JsonTreeNode>, val root: String)

class JsonTreeNode(val id: String, val left: String? = null, val right: String? = null, val value: Int)

open class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var id: String? = null
}
