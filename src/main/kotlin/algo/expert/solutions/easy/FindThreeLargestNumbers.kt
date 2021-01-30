package algo.expert.solutions.easy

fun findThreeLargestNumbers(array: List<Int>): List<Int> {

    var largestThreeIndexes = mutableListOf<Int?>()

    while (largestThreeIndexes.size < 3) {

        var currentLargestIndex: Int? = null
        for (i in array.indices) {
            if (i !in largestThreeIndexes) {
                if (currentLargestIndex == null) {
                    currentLargestIndex = i
                    continue
                }
                if (array[i] >= array[currentLargestIndex]) {
                    currentLargestIndex = i
                }
            }
        }
        largestThreeIndexes.add(currentLargestIndex)
    }

    return largestThreeIndexes.mapNotNull { it }.map {
        array[it]
    }.sorted()
}
