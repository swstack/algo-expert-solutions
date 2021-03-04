package algo.expert.solutions.medium

fun firstDuplicateValue(array: MutableList<Int>): Int {
    var lowestIdx = -1
    for (i in 0..array.size - 2) {
        for (j in i + 1 until array.size) {
            if (i != j) {
                if (array[i] == array[j]) {
                    if (lowestIdx == -1 || j < lowestIdx) {
                        lowestIdx = j
                        continue
                    }
                }
            }
        }
    }

    return if (lowestIdx == -1) {
        -1
    } else {
        array[lowestIdx]
    }
}
