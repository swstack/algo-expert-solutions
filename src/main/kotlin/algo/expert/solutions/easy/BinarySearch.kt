package algo.expert.solutions.easy

fun binarySearch(array: List<Int>, target: Int): Int {
    if (array.isEmpty()) {
        return -1
    }
    val middleIdx = array.size / 2
    val middle = array[middleIdx]
    if (middle == target) {
        return middleIdx
    } else if (target < middle) {
        val idxInner = binarySearch(array.subList(0, middleIdx), target)
        return idxInner
    } else {
        val idxInner = binarySearch(array.subList(middleIdx + 1, array.size), target)
        if (idxInner != -1) {
            return middleIdx + 1 + idxInner
        } else {
            return idxInner
        }

    }
}
