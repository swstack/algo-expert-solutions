package algo.expert.solutions.easy

fun runLengthEncoding(string: String): String {
    if (string.isEmpty()) {
        return ""
    }

    var encoding = ""
    var currentRun = string[0]
    var currentRunSize = 1
    for (i in 1 until string.length) {
        val next = string[i]

        if (currentRunSize >= 9) {
            encoding += "${currentRunSize}${currentRun}"
            currentRun = next
            currentRunSize = 1
            continue
        }

        if (next == currentRun) {
            currentRunSize++
        } else {
            encoding += "${currentRunSize}${currentRun}"
            currentRun = next
            currentRunSize = 1
        }
    }

    encoding += "${currentRunSize}${currentRun}"

    return encoding
}
