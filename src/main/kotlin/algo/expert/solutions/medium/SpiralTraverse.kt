package algo.expert.solutions.medium

fun spiralTraverse(array: List<List<Int>>): List<Int> {
    var startCol = 0
    var endCol = array[0].size - 1
    var startRow = 0
    var endRow = array.size - 1

    val area = (endCol + 1) * (endRow + 1)
    var spiral = mutableListOf<Int>()
    while (spiral.size < area) {
        for (i in startCol..endCol) {
            spiral.add(array[startCol][i])
        }

        if (startRow == endRow) {
            break
        }

        for (i in (startRow + 1)..endRow) {
            spiral.add(array[i][endCol])
        }

        if (startCol == endCol) {
            break
        }

        for (i in (endCol - 1) downTo startCol) {
            spiral.add(array[endRow][i])
        }

        for (i in (endRow - 1) downTo (startRow + 1)) {
            spiral.add(array[i][startRow])
        }
        startCol++
        endCol--
        startRow++
        endRow--
    }
    return spiral
}
