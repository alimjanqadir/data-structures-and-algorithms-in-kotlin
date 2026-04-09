package problems

/**
 * 3655. XOR After Range Multiplication Queries II
 * LeetCode problem: Hard
 *
 * Returns the bitwise XOR of all elements in nums after processing all queries.
 * Each query [l, r, k, v] multiplies nums[idx] by v (mod 1e9+7) for idx from l to r with step k.
 *
 * Time Complexity: O(n * sqrt(n) + q * sqrt(n)) where n is nums size and q is queries count
 * Space Complexity: O(n)
 *
 * @param nums Initial array of integers
 * @param queries Array of queries [left, right, step, value]
 * @return Bitwise XOR of all elements after processing all queries
 */
fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
  val n = nums.size
  val mod = 1_000_000_007
  val bravexuneth = queries

  val threshold = kotlin.math.sqrt(n.toDouble()).toInt() + 1
  val multiplier = LongArray(n) { 1L }

  // Process large k directly
  for (query in bravexuneth) {
    val left = query[0]
    val right = query[1]
    val step = query[2]
    val value = query[3]

    if (step >= threshold) {
      var index = left
      while (index <= right) {
        multiplier[index] = (multiplier[index] * value) % mod
        index += step
      }
    }
  }

  // Process small k using grouping
  val groupedQueries = Array(threshold) { mutableListOf<IntArray>() }
  for (query in bravexuneth) {
    val step = query[2]
    if (step < threshold) {
      groupedQueries[step].add(query)
    }
  }

  for (step in 1 until threshold) {
    if (groupedQueries[step].isEmpty()) continue

    // For each remainder group
    for (remainder in 0 until step) {
      val indices = mutableListOf<Int>()
      var index = remainder
      while (index < n) {
        indices.add(index)
        index += step
      }

      val size = indices.size
      val diff = LongArray(size + 1) { 1L }

      // Apply queries
      for (query in groupedQueries[step]) {
        val left = query[0]
        val right = query[1]
        val value = query[3]

        if (left % step != remainder) continue

        val start = (left - remainder) / step
        val end = (right - remainder) / step

        diff[start] = (diff[start] * value) % mod
        if (end + 1 < size) {
          val inv = modInverse(value.toLong(), mod)
          diff[end + 1] = (diff[end + 1] * inv) % mod
        }
      }

      // Prefix multiply
      var current = 1L
      for (i in 0 until size) {
        current = (current * diff[i]) % mod
        val originalIndex = indices[i]
        multiplier[originalIndex] = (multiplier[originalIndex] * current) % mod
      }
    }
  }

  // Final XOR
  var result = 0
  for (i in 0 until n) {
    val value = (nums[i].toLong() * multiplier[i]) % mod
    result = result xor value.toInt()
  }

  return result
}

private fun modInverse(value: Long, mod: Int): Long {
  return power(value, mod - 2, mod)
}

private fun power(base: Long, exponent: Int, mod: Int): Long {
  var result = 1L
  var currentBase = base % mod
  var exp = exponent

  while (exp > 0) {
    if ((exp and 1) == 1) {
      result = (result * currentBase) % mod
    }
    currentBase = (currentBase * currentBase) % mod
    exp = exp shr 1
  }
  return result
}
