package algo.expert.solutions.easy

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(): List<String> {
        return depthFirstSearchRecursive(mutableListOf())
    }

    fun depthFirstSearchRecursive(names: MutableList<String>): List<String> {
        names.add(name)
        for (child in children) {
            if (child.name !in names) {
                child.depthFirstSearchRecursive(names)
            }
        }
        return names
    }
}
