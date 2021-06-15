package algo.expert.solutions.easy

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val points = HashMap<String, Int>()
    for (i in competitions.indices) {
        val c = competitions[i]
        val r = results[i]

        val winner: String = if (r == 0) {
            c[1]
        } else {
            c[0]
        }

        points[winner] = points.getOrDefault(winner, 0) + 3
    }

    var leader = ""
    var leaderPoints = 0
    for ((k, v) in points) {
        if (v >= leaderPoints) {
            leaderPoints = v
            leader = k
        }
    }

    return leader
}
