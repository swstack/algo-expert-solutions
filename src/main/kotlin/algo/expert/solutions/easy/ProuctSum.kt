package algo.expert.solutions.easy

fun productSum(array: List<*>): Int {
    return productSumRecursive(array, 0, 1)
}

fun productSumRecursive(array: List<*>, sum: Int, level: Int): Int {
    var sum = sum
    for (e in array) {
        if (e is List<*>) {
            val innerSum = productSumRecursive(e, 0, level + 1)
            sum += (level + 1) * innerSum
        } else {
            sum += e as Int
        }
    }

    return sum
}
