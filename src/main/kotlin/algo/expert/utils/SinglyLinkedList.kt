package algo.expert.utils

import com.beust.klaxon.Klaxon

/*
Load singly LinkedList given a data structure like:

{
    "head": "1",
    "nodes": [
      {"id": "1", "next": "1-2", "value": 1},
      {"id": "1-2", "next": "1-3", "value": 1},
      {"id": "1-3", "next": "2", "value": 1},
      {"id": "2", "next": "3", "value": 3},
      {"id": "3", "next": "3-2", "value": 4},
      {"id": "3-2", "next": "3-3", "value": 4},
      {"id": "3-3", "next": "4", "value": 4},
      {"id": "4", "next": "5", "value": 5},
      {"id": "5", "next": "5-2", "value": 6},
      {"id": "5-2", "next": null, "value": 6}
    ]
}
*/

open class SinglyLinkedList(var value: Int) {
    var next: SinglyLinkedList? = null
}

fun loadSLL(json: String): SinglyLinkedList? {
    var sll: SinglyLinkedList? = null
    Klaxon().parse<JsonSLL>(json)?.let { jsonSLL ->
        // Populate hashmap of id:JsonSLLNode
        val nodesMap = mutableMapOf<String, SinglyLinkedList>()
        for (node in jsonSLL.nodes) {
            nodesMap[node.id] = SinglyLinkedList(node.value)
        }

        // Connect the nodes
        for (node in jsonSLL.nodes) {
            nodesMap[node.id]?.let { root ->
                root.next = nodesMap[node.next]
            }
        }

        sll = nodesMap[jsonSLL.head]
    }

    return sll
}

class JsonSLL(val nodes: List<JsonSLLNode>, val head: String)

class JsonSLLNode(val id: String, val next: String?, val value: Int)


