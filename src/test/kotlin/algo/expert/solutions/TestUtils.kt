package algo.expert.solutions

import algo.expert.utils.GraphNode
import algo.expert.utils.TreeNode
import algo.expert.utils.loadGraph
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TestUtils {
    @Test
    fun testTreeUtils() {
        val jsonTree = """
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
            """.trimIndent()

        val root = algo.expert.utils.loadTree(jsonTree)
        assertNotNull(root)
        root.let { node ->
            var stack = Stack<TreeNode>()
            stack.push(node)
            var visited = mutableListOf<Int>()
            while (!stack.isEmpty()) {
                var next = stack.pop()
                if (next.left != null) {
                    stack.push(next.left)
                }

                if (next.right != null) {
                    stack.push(next.right)
                }

                visited.add(next.value)
            }

            assertEquals(visited, listOf(1, 3, 7, 6, 2, 5, 10, 4, 9, 8))
        }
    }

    @Test
    fun testGraphUtils() {
        val json = """
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
        """.trimIndent()

        val graph = loadGraph(json)
        assertNotNull(graph)

        var stack = Stack<GraphNode>()
        stack.push(graph)
        var visited = mutableListOf<String>()
        while (!stack.isEmpty()) {
            var next = stack.pop()
            for (child in next.children) {
                stack.push(child)
            }

            visited.add(next.value)
        }

        assertEquals(visited, listOf("A", "D", "H", "G", "K", "C", "B", "F", "J", "I", "E"))
    }
}
