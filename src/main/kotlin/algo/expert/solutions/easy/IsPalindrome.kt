package algo.expert.solutions.easy

fun isPalindrome(string: String): Boolean {
    var reversed = ""
    for (i in string.length - 1 downTo 0) {
        reversed += string[i]
    }

    return string == reversed
}