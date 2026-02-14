package problems

/**
 * Solution for adding two binary strings
 * Time Complexity: O(max(N, M)) where N and M are lengths of input strings
 * Space Complexity: O(max(N, M)) for the result string
 */
fun addBinary(a: String, b: String): String {
  var indexA = a.length - 1
  var indexB = b.length - 1
  var carry = 0

  val reversedResult = StringBuilder()

  while (indexA >= 0 || indexB >= 0 || carry != 0) {
    val digitFromA =
      if (indexA >= 0) a[indexA] - '0' else 0

    val digitFromB =
      if (indexB >= 0) b[indexB] - '0' else 0

    val sum = digitFromA + digitFromB + carry

    val resultDigit = sum % 2
    carry = sum / 2

    reversedResult.append(resultDigit)

    indexA -= 1
    indexB -= 1
  }

  return reversedResult.reverse().toString()
}
