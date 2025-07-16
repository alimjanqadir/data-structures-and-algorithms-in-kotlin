package problems

/**
 * LeetCode 3201: Find the Maximum Length of Valid Subsequence I.
 *
 * Runs in O(nums.size) time using O(1) extra space.
 */
fun maximumLength(nums: IntArray): Int {
  var evenCount = 0
  var oddCount = 0
  var alternatingEndingWithEven = 0
  var alternatingEndingWithOdd = 0

  for (currentValue in nums) {
    if (currentValue and 1 == 0) {
      alternatingEndingWithEven = maxOf(
        alternatingEndingWithEven,
        alternatingEndingWithOdd + 1
      )
      evenCount += 1
    } else {
      alternatingEndingWithOdd = maxOf(
        alternatingEndingWithOdd,
        alternatingEndingWithEven + 1
      )
      oddCount += 1
    }
  }

  return maxOf(
    evenCount,
    oddCount,
    alternatingEndingWithEven,
    alternatingEndingWithOdd
  )
}

