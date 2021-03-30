package algo.expert.solutions.medium

fun numberOfWaysToMakeChange(n: Int, denoms: List<Int>): Int {
    var ways = IntArray(n + 1)
    ways[0] = 1
    for (denom in denoms) {
        for (i in 1 until n + 1) {
            if (denom <= i) {
                ways[i] += ways[i - denom]
            }
        }
    }
    return ways[n]
}
