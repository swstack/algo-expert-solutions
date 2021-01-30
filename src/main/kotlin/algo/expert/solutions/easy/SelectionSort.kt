package algo.expert.solutions.easy

fun selectionSort(array: MutableList<Int>): List<Int> {
    var sortedIndex = 0
    while (sortedIndex < array.size) {
        var smallestIndex = sortedIndex
        for (i in sortedIndex + 1 until array.size) {
            if (array[i] < array[smallestIndex]) {
                smallestIndex = i
            }
        }

        val tmp = array[sortedIndex]
        array[sortedIndex] = array[smallestIndex]
        array[smallestIndex] = tmp

        sortedIndex++
    }

    return array
}
