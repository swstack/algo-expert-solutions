package algo.expert.solutions.easy

fun getNthFib(n: Int): Int {
    if (n == 0) {
        return 0
    }

    if (n == 1) {
        return 1
    }

    return getNthFib(n - 1) + getNthFib(n - 2)
}
