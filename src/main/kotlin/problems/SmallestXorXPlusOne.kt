package problems

/**
 * Solution for finding the smallest non-negative integer x for each number in the input list
 * such that x | (x + 1) equals the number.
 *
 * Problem:
 * For each number in the input list, find the smallest non-negative integer x such that x | (x + 1) equals the number.
 * If no such x exists, return -1 for that position.
 *
 * Example:
 * Input: [3, 7, 15]
 * Output: [1, 3, 7]
 *
 * Explanation:
 * - For 3: 1 | 2 = 3, so return 1
 * - For 7: 3 | 4 = 7, so return 3
 * - For 15: 7 | 8 = 15, so return 7
 */
fun smallestXorXPlusOne(nums: List<Int>): IntArray {
  val result = IntArray(nums.size)

  for (index in nums.indices) {
    val value = nums[index]

    // If the number is even, there's no solution since x | (x+1) is always odd
    if (value % 2 == 0) {
      result[index] = -1
      continue
    }

    // Count the number of trailing 1s in binary representation
    var trailingOnes = 0
    var temp = value
    while ((temp and 1) == 1) {
      trailingOnes++
      temp = temp shr 1
    }

    // The result is value - 2^(trailingOnes - 1)
    val k = trailingOnes - 1
    result[index] = value - (1 shl k)
  }

  return result
}
