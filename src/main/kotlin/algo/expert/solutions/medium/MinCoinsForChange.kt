package algo.expert.solutions.medium

fun minNumberOfCoinsForChange(n: Int, denoms: List<Int>): Int {
    if (n == 0) return 0

    var leastCoins: Int? = null
    for (split in denoms.indices) {
        val left = denoms.subList(0, split)
        val mid = denoms[split]
        val right = denoms.subList(split + 1, denoms.size)
        val combo  = mutableListOf<Int>()
        combo.add(mid)
        combo.addAll(left)
        combo.addAll(right)

        var tot = n
        val coins = mutableListOf<Int>()
        for (denom in combo) {
            while (tot - denom >= 0) {
                coins.add(denom)
                tot -= denom
            }
        }

        if (leastCoins == null || coins.size < leastCoins) {
            leastCoins = coins.size
        }
        println(combo)
    }

    return leastCoins ?: -1
}
