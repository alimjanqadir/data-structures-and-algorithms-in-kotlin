package problems.maximumtotaldamage

class Solution {
  fun maximumTotalDamage(power: IntArray): Long {
    // 1) Aggregate count per damage value
    val frequency: MutableMap<Int, Long> = HashMap()
    for (damage in power) {
      val current = frequency.getOrDefault(damage, 0L)
      frequency[damage] = current + 1L
    }

    // 2) Build sorted distinct damage values and their weights
    val distinctDamages = frequency.keys.toMutableList()
    distinctDamages.sort()
    val uniqueCount = distinctDamages.size

    val weights = LongArray(uniqueCount)
    for (index in 0 until uniqueCount) {
      val damageValue = distinctDamages[index]
      val countForValue = frequency[damageValue] ?: 0L
      // weight = total damage contributed if we choose all spells with this damage
      weights[index] = countForValue * damageValue.toLong()
    }

    // 3) For each index, find the rightmost index with damage <= currentDamage - 3
    fun findPrevIndex(currentDamage: Int): Int {
      var left = 0
      var right = uniqueCount - 1
      var answer = -1
      val limit = currentDamage - 3
      while (left <= right) {
        val mid = left + (right - left) / 2
        val midValue = distinctDamages[mid]
        if (midValue <= limit) {
          answer = mid
          left = mid + 1
        } else {
          right = mid - 1
        }
      }
      return answer
    }

    // 4) DP
    val best = LongArray(uniqueCount)
    for (index in 0 until uniqueCount) {
      val includeValue = run {
        val prev = findPrevIndex(distinctDamages[index])
        val prevBest = if (prev >= 0) best[prev] else 0L
        prevBest + weights[index]
      }
      val excludeValue = if (index > 0) best[index - 1] else 0L
      best[index] = if (includeValue > excludeValue) includeValue else excludeValue
    }

    return if (uniqueCount == 0) 0L else best[uniqueCount - 1]
  }
}
