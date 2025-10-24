package problems.push

fun hasSameFinalDigits(s: String): Boolean {
  var digits = s.map { it - '0' }.toMutableList()

  while (digits.size > 2) {
    val nextDigits = mutableListOf<Int>()
    for (index in 0 until digits.size - 1) {
      nextDigits.add((digits[index] + digits[index + 1]) % 10)
    }
    digits = nextDigits
  }

  return digits[0] == digits[1]
}
