package problems

/**
 * LeetCode Problem: Minimum Operations to Make GCD of Array Equal to K
 * 
 * This solution calculates the minimum operations needed to make the GCD of the array equal to 1.
 * If the array already contains 1, the answer is simply n - count_of_1s.
 * Otherwise, it finds the smallest subarray with GCD 1 and calculates operations needed.
 */
fun minOperationsToMakeGCDOne(nums: IntArray): Int {
  val n = nums.size
  var count1 = 0
  for (num in nums) {
    if (num == 1) count1++
  }
  if (count1 > 0) return n - count1
    
  var minOps = Int.MAX_VALUE
  for (i in 0 until n) {
    var g = nums[i]
    for (j in i + 1 until n) {
      g = gcd(g, nums[j])
      if (g == 1) {
        minOps = minOf(minOps, j - i + n - 1)
        break
      }
    }
  }
  return if (minOps == Int.MAX_VALUE) -1 else minOps
}

private fun gcd(a: Int, b: Int): Int {
  return if (b == 0) a else gcd(b, a % b)
}
