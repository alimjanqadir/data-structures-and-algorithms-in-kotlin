package problems

fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
  val length = nums.size
  if (2 * k > length) return false  // guaranteed by constraints, but safe

  // isRise[i] = 1 if nums[i] < nums[i+1], else 0
  val rises = IntArray(length - 1)
  for (gapStart in 0 until length - 1) {
    rises[gapStart] = if (nums[gapStart] < nums[gapStart + 1]) 1 else 0
  }

  // prefixSums[g] = sum of rises[0..g-1]
  val prefixSums = IntArray(length)  // one longer than rises
  for (index in 0 until length - 1) {
    prefixSums[index + 1] = prefixSums[index] + rises[index]
  }

  // Helper to sum rises[l..r] inclusive in O(1)
  fun sumRises(fromInclusive: Int, toInclusive: Int): Int {
    if (fromInclusive > toInclusive) return 0
    return prefixSums[toInclusive + 1] - prefixSums[fromInclusive]
  }

  val neededGapsPerBlock = k - 1
  // Try every starting index 'a' for the left subarray
  // Right subarray starts at a + k; last valid a is length - 2k
  for (startIndex in 0..(length - 2 * k)) {
    val leftOk = sumRises(startIndex, startIndex + k - 2) == neededGapsPerBlock
    if (!leftOk) continue
    val rightOk = sumRises(startIndex + k, startIndex + 2 * k - 2) == neededGapsPerBlock
    if (rightOk) return true
  }
  return false
}
