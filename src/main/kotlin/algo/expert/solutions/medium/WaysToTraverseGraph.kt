package algo.expert.solutions.medium

fun numberOfWaysToTraverseGraph(width: Int, height: Int): Int {
    if (height == 1) return 1
    if (width == 1) return 1

    val left = numberOfWaysToTraverseGraph(width - 1, height)
    val up = numberOfWaysToTraverseGraph(width, height - 1)

    return left + up
}
