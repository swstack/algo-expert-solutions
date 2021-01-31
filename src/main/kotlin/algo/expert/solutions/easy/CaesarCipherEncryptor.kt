package algo.expert.solutions.easy

fun caesarCipherEncryptor(string: String, key: Int): String {
    val asciiOffset = 96
    var encryptedString = ""
    for (c in string) {
        val cVal = c.toInt() - asciiOffset
        val encryptedVal = (cVal + key) % 26

        encryptedString += if (encryptedVal == 0) {
            'z'
        } else {
            (encryptedVal + asciiOffset).toChar()
        }
    }
    return encryptedString
}
