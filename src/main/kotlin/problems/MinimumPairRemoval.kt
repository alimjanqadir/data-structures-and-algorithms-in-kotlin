package problems

fun minimumPairRemoval(nums: IntArray): Int {
  val n = nums.size
  if (n <= 1) return 0

  // Use Long to prevent overflow: nums[i] can be -1e9 to 1e9, sum can be -2e9 to 2e9
  val arr = LongArray(n) { nums[it].toLong() }

  // (sum, left_index) — min-heap by sum, then by index (leftmost)
  val pairs = java.util.TreeSet<Pair<Long, Int>> { a, b ->
    if (a.first != b.first) a.first.compareTo(b.first)
    else a.second.compareTo(b.second)
  }

  // Active original indices (sorted)
  val active = java.util.TreeSet<Int>()

  var inv = 0
  for (i in 0 until n) {
    active.add(i)
    if (i < n - 1 && arr[i] > arr[i + 1]) inv++
  }

  for (i in 0 until n - 1) {
    pairs.add(arr[i] + arr[i + 1] to i)
  }

  var ans = 0

  while (inv > 0) {
    ans++

    // Get leftmost min-sum pair
    val (sum, i) = pairs.pollFirst() ?: break

    // Find current right neighbor
    val idxHigher = active.higher(i) ?: continue  // should not happen
    val j = idxHigher

    // Merge: arr[i] = sum, remove j
    val oldLeft = arr[i]
    arr[i] = sum

    // Update inversions & affected pairs

    // 1. Old (i,j) inversion disappears if it was inverted
    if (oldLeft > arr[j]) inv--

    // 2. Left neighbor of i (if exists)
    val prev = active.lower(i)
    if (prev != null) {
      if (arr[prev] > oldLeft) inv--
      pairs.remove(arr[prev] + oldLeft to prev)
      if (arr[prev] > sum) inv++
      pairs.add(arr[prev] + sum to prev)
    }

    // 3. Right neighbor of j (if exists)
    val next = active.higher(j)
    if (next != null) {
      if (arr[j] > arr[next]) inv--
      pairs.remove(arr[j] + arr[next] to j)
      if (sum > arr[next]) inv++
      pairs.add(sum + arr[next] to i)   // new pair starts at i
    }

    // Remove the merged position j
    active.remove(j)
  }

  return ans
}
