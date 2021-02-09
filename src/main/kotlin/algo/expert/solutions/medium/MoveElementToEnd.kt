package algo.expert.solutions.medium

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {

    for (i in array.indices) {
        if (array[i] == toMove) {
            for (j in array.size - 1 downTo i) {
                if (array[j] != toMove) {
                    val tmp = array[i]
                    array[i] = array[j]
                    array[j] = tmp
                }
            }
        }
    }

    return array
}
