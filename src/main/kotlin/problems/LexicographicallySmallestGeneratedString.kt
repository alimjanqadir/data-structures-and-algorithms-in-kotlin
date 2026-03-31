package problems

fun generateString(str1: String, str2: String): String {
    val n = str1.length
    val m = str2.length
    val resultLength = n + m - 1

    val result = CharArray(resultLength) { 'a' }
    val locked = BooleanArray(resultLength)

    // Step 1: Apply 'T'
    for (index in 0 until n) {
        if (str1[index] == 'T') {
            for (offset in 0 until m) {
                val pos = index + offset
                val charFromStr2 = str2[offset]

                if (locked[pos] && result[pos] != charFromStr2) {
                    return ""
                }
                result[pos] = charFromStr2
                locked[pos] = true
            }
        }
    }

    // Step 2: Handle 'F'
    for (index in 0 until n) {
        if (str1[index] == 'F') {
            var matches = true

            for (offset in 0 until m) {
                if (result[index + offset] != str2[offset]) {
                    matches = false
                    break
                }
            }

            if (matches) {
                var fixed = false

                // Only modify unlocked positions - change to 'b' for lexicographically smallest
                for (offset in m - 1 downTo 0) {
                    val pos = index + offset

                    if (!locked[pos]) {
                        result[pos] = 'b'
                        fixed = true
                        break
                    }
                }

                if (!fixed) return ""
            }
        }
    }

    return String(result)
}
