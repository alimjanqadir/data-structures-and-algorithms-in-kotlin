package problems

fun checkPowersOfThree(n: Int): Boolean {
  var remaining = n
  while (remaining > 0) {
    val base3Digit = remaining % 3
    if (base3Digit == 2) return false
    remaining /= 3
  }
  return true
}
