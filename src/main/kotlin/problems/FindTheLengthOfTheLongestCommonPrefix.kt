package problems

fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
  val prefixes = HashSet<Int>()

  for (number in arr1) {
    var currentNumber = number

    while (currentNumber > 0) {
      prefixes.add(currentNumber)
      currentNumber /= 10
    }
  }

  var longestLength = 0

  for (number in arr2) {
    var currentNumber = number

    while (currentNumber > 0) {
      if (prefixes.contains(currentNumber)) {
        longestLength = maxOf(longestLength, currentNumber.toString().length)
        break
      }

      currentNumber /= 10
    }
  }

  return longestLength
}
