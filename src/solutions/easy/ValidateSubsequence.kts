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


isValidSubsequence(listOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(1, 6, -1, 10))
isValidSubsequence(listOf(1, 2, 3, 4, 5), listOf(6, 7))