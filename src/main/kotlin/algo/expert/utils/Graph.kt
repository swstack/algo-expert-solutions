package algo.expert.utils

import com.beust.klaxon.Klaxon

/*
Load graph given a json object:

{
    "nodes": [
      {"children": ["B", "C", "D"], "id": "A", "value": "A"},
      {"children": ["E", "F"], "id": "B", "value": "B"},
      {"children": [], "id": "C", "value": "C"},
      {"children": ["G", "H"], "id": "D", "value": "D"},
      {"children": [], "id": "E", "value": "E"},
      {"children": ["I", "J"], "id": "F", "value": "F"},
      {"children": ["K"], "id": "G", "value": "G"},
      {"children": [], "id": "H", "value": "H"},
      {"children": [], "id": "I", "value": "I"},
      {"children": [], "id": "J", "value": "J"},
      {"children": [], "id": "K", "value": "K"}
    ],
    "startNode": "A"
}
 */
fun loadGraph(jsonTreeSerialized: String): GraphNode? {

    var graph: GraphNode? = null
    Klaxon().parse<JsonGraph>(jsonTreeSerialized)?.let { jsonGraph ->

        // Populate hashmap of value:GraphNode
        val nodesMap = mutableMapOf<String, GraphNode>()
        for (node in jsonGraph.nodes) {
            val graphNode = GraphNode(node.value)
            graphNode.id = node.id
            nodesMap[graphNode.value] = graphNode
        }

        // Connect the nodes
        for (node in jsonGraph.nodes) {
            nodesMap[node.value]?.let { root ->
                for (child in node.children) {
                    nodesMap[child]?.let {
                        root.children.add(it)
                    }
                }
            }
        }

        graph = nodesMap[jsonGraph.startNode]
    }

    return graph
}

class JsonGraph(val nodes: List<JsonGraphNode>, val startNode: String)

class JsonGraphNode(val id: String, val children: List<String>, val value: String)

open class GraphNode(var value: String) {
    var children: MutableList<GraphNode> = mutableListOf()
    var id: String? = null
}
