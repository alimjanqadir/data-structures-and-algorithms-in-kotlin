// Solution for LeetCode problem: CountInterestingSubarrays
// Top-level function as per project conventions

fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
  val freq = HashMap<Int, Long>()
  freq[0] = 1L
  var prefixSum = 0
  var answer = 0L
  for (v in nums) {
    val add = if (v % modulo == k) 1 else 0
    prefixSum += add
    val need = ((prefixSum - k) % modulo + modulo) % modulo
    answer += freq.getOrDefault(need, 0L)
    val currMod = ((prefixSum % modulo) + modulo) % modulo
    freq[currMod] = freq.getOrDefault(currMod, 0L) + 1
  }
  return answer
}
