package algo.expert.solutions.medium

fun arrayOfProducts(array: List<Int>): List<Int> {
    var results = IntArray(array.size)
    for (i in array.indices) {
        var product: Int? = null
        for (j in array.indices) {
            if (i != j) {
                product = if (product == null) {
                    array[j]
                } else {
                    product?.times(array[j])
                }
            }
        }

        if (product != null) {
            results[i] = product
        }
    }
    return results.toList()
}
