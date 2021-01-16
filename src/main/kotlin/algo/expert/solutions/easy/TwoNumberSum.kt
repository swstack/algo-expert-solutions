package algo.expert.solutions.easy

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    array.forEach { x ->
        array.forEach { y ->
            if (x != y && x + y == targetSum) {
                return listOf(x, y)
            }
        }
    }

    return listOf()
}
