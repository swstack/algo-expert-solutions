package algo.expert.solutions.medium

enum class Direction {
    INCREASING,
    DECREASING,
}

fun isMonotonic(array: List<Int>): Boolean {
    var monotonic = true
    var direction: Direction? = null
    var newDirection: Direction
    loop@ for (i in 1 until array.size) {

        val a = array[i - 1]
        val b = array[i]
        newDirection = when {
            a > b -> {
                Direction.DECREASING
            }
            a < b -> {
                Direction.INCREASING
            }
            else -> {
                continue@loop
            }
        }

        if (direction != null && newDirection != direction) {
            monotonic = false
            break
        }

        direction = newDirection
    }

    return monotonic
}
