package problems

/**
 * LeetCode 2657. Find the Prefix Common Array of Two Arrays
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
 */
fun findThePrefixCommonArray(a: IntArray, b: IntArray): IntArray {
  val arrayLength = a.size

  val seenInA = BooleanArray(arrayLength + 1)
  val seenInB = BooleanArray(arrayLength + 1)

  val prefixCommonArray = IntArray(arrayLength)

  var commonCount = 0

  for (index in 0 until arrayLength) {
    val valueFromA = a[index]
    val valueFromB = b[index]

    seenInA[valueFromA] = true
    seenInB[valueFromB] = true

    if (seenInA[valueFromB]) {
      commonCount += 1
    }

    if (valueFromA != valueFromB && seenInB[valueFromA]) {
      commonCount += 1
    }

    prefixCommonArray[index] = commonCount
  }

  return prefixCommonArray
}
