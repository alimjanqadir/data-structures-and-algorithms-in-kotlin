package problems

fun processStr(s: String): String {
    val resultBuilder = StringBuilder()

    for (currentCharacter in s) {
        when (currentCharacter) {
            in 'a'..'z' -> {
                resultBuilder.append(currentCharacter)
            }
            '*' -> {
                if (resultBuilder.isNotEmpty()) {
                    resultBuilder.deleteCharAt(resultBuilder.length - 1)
                }
            }
            '#' -> {
                val currentText = resultBuilder.toString()
                resultBuilder.append(currentText)
            }
            '%' -> {
                resultBuilder.reverse()
            }
        }
    }

    return resultBuilder.toString()
}
