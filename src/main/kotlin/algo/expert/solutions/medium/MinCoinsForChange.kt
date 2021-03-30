package algo.expert.solutions.medium

import java.lang.Integer.min

fun minNumberOfCoinsForChange(n: Int, denoms: List<Int>): Int {
    val coins = IntArray(n + 1) { -1 }
    coins[0] = 0
    for (d in denoms.sorted()) {
        for (i in 1 until coins.size) {
            if (d <= i) {
                val remaining = i - d
                val remainingCoins = coins[remaining]
                if (remainingCoins != -1) {
                    if (coins[i] == -1) {
                        coins[i] = 1 + remainingCoins
                    } else {
                        coins[i] = min(coins[i], 1 + remainingCoins)
                    }
                }
            }
        }
    }
    return coins[n]
}
