package algo.expert.solutions.medium

fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {

    array.sort()
    var sums = mutableListOf<List<Int>>()
    for (i in 0 until array.size) {
        for (j in i + 1 until array.size) {
            for (k in j + 1 until array.size) {
                if (array[i] + array[j] + array[k] == targetSum) {
                    sums.add(listOf(array[i], array[k], array[j]).sorted())
                }
            }
        }
    }

    return sums
}