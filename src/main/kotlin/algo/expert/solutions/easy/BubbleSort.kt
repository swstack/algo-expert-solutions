package algo.expert.solutions.easy

fun bubbleSort(array: MutableList<Int>): List<Int> {
    var sorted = false
    while(!sorted) {
        sorted = true
        for (i in 1 until array.size) {
            if (array[i - 1] > array[i]) {
                val tmp = array[i]
                array[i] = array[i - 1]
                array[i - 1] = tmp
                sorted = false
            }
        }
    }
    return array
}
