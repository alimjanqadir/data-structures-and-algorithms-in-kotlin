package problems

/**
 * LeetCode: Divide Array Into Arrays With Max Difference
 * https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
 */
fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
  nums.sort()
  val result = mutableListOf<IntArray>()
  for (i in nums.indices step 3) {
    if (nums[i + 2] - nums[i] > k) return emptyArray()
    result.add(intArrayOf(nums[i], nums[i + 1], nums[i + 2]))
  }
  return result.toTypedArray()
}
