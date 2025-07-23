// Brute Force Solution - O(n²)
fun containsNearbyDuplicateBrute(nums: IntArray, k: Int): Boolean {
  for (i in nums.indices) {
    for (j in i + 1..minOf(i + k, nums.lastIndex)) {
      if (nums[i] == nums[j]) return true
    }
  }
  return false
}

// Optimized Solution using Sliding Window with HashSet - O(n)
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
  val window = HashSet<Int>()

  for (i in nums.indices) {
    if (i > k) window.remove(nums[i - k - 1])
    if (!window.add(nums[i])) return true
  }
  return false
}

// Functional Solution using windowed
fun containsNearbyDuplicateFunctional(nums: IntArray, k: Int): Boolean {
  return nums.withIndex()
    .groupBy { it.value }
    .any { (_, indices) ->
      indices.windowed(2)
        .any { (a, b) -> b.index - a.index <= k }
    }
}

