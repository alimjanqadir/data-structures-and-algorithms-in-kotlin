package problems

fun mirrorDistance(n: Int): Int {
  var originalNumber = n
  var reversedNumber = 0

  while (originalNumber > 0) {
    val lastDigit = originalNumber % 10
    reversedNumber = reversedNumber * 10 + lastDigit
    originalNumber /= 10
  }

  return kotlin.math.abs(n - reversedNumber)
}
