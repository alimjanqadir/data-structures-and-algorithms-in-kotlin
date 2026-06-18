class Solution {
    fun processStr(s: String, k: Long): Char {
        var currentLength = 0L

        for (character in s) {
            when (character) {
                in 'a'..'z' -> currentLength += 1L
                '*' -> if (currentLength > 0L) currentLength -= 1L
                '#' -> currentLength *= 2L
                '%' -> {}
            }
        }

        if (k >= currentLength) return '.'

        var targetIndex = k
        var remainingLength = currentLength

        for (position in s.length - 1 downTo 0) {
            when (val character = s[position]) {
                in 'a'..'z' -> {
                    if (remainingLength == 0L) return '.'
                    if (targetIndex == remainingLength - 1L) return character
                    remainingLength -= 1L
                }

                '*' -> {
                    remainingLength += 1L
                }

                '#' -> {
                    val previousLength = remainingLength / 2L
                    if (previousLength > 0L && targetIndex >= previousLength) {
                        targetIndex -= previousLength
                    }
                    remainingLength = previousLength
                }

                '%' -> {
                    if (remainingLength > 0L) {
                        targetIndex = remainingLength - 1L - targetIndex
                    }
                }
            }
        }

        return '.'
    }
}