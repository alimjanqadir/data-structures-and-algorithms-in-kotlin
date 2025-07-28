package problems

/**
 * Returns the number of non-empty subsets of [nums] whose bitwise OR is maximum.
 * The maximum OR is the bitwise OR of all elements in the array.
 */
fun countMaxOrSubsets(nums: IntArray): Int {
  val maximumOr = nums.fold(0) { acc, element -> acc or element }
  val elementCount = nums.size

  // numberOfFreeChoices[r] = 2^r, used when we've already hit maximumOr
  val numberOfFreeChoices = LongArray(elementCount + 1).apply {
    this[0] = 1L
    for (remaining in 1..elementCount) this[remaining] = this[remaining - 1] shl 1
  }

  // Memo key packs (nextIndex, currentOr)
  val memoizedCounts = HashMap<Long, Long>()

  fun countSubsetsReachingMaximumOr(nextIndex: Int, currentOr: Int): Long {
    if (currentOr == maximumOr) {
      // Any subset of the remaining tail keeps OR == maximumOr
      return numberOfFreeChoices[elementCount - nextIndex]
    }
    if (nextIndex == elementCount) return 0L

    val stateKey = (nextIndex.toLong() shl 32) or (currentOr.toLong() and 0xffffffffL)
    memoizedCounts[stateKey]?.let { return it }

    val skipCurrent = countSubsetsReachingMaximumOr(nextIndex + 1, currentOr)
    val takeCurrent = countSubsetsReachingMaximumOr(nextIndex + 1, currentOr or nums[nextIndex])

    val totalForState = skipCurrent + takeCurrent
    memoizedCounts[stateKey] = totalForState
    return totalForState
  }

  return countSubsetsReachingMaximumOr(0, 0).toInt()
}

