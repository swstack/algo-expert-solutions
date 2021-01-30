package algo.expert.solutions.easy

fun insertionSort(array: MutableList<Int>): List<Int> {
    for (i in 1 until array.size) {
        for (j in i - 1 downTo 0) {
            val curr = array[j + 1]
            if (curr < array[j]) {
                array[j + 1] = array[j]
                array[j] = curr
            } else {
                continue
            }
        }
    }
    return array
}
