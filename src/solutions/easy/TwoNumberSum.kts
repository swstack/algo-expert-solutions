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

twoNumberSum(mutableListOf(1, 5, 2, 4, 6, 8, 9), 6)
twoNumberSum(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10)
