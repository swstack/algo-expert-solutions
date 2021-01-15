package algo.expert.solutions.easy

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var x = 0

    for (y in array) {
        if (sequence[x] == y) {
            x++
            if (x >= sequence.size) {
                return true
            }
        }
    }

    return false
}
