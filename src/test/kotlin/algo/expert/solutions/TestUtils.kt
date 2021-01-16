package algo.expert.solutions

import algo.expert.utils.TreeNode
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TestUtils {
    @Test
    fun testTreeUtils() {
        val jsonTree = """
            {
              "tree": {
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
            }
            """.trimIndent()

        val root = algo.expert.utils.load(jsonTree)
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
}
