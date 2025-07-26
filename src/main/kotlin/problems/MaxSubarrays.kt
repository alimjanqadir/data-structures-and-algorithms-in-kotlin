package problems

/**
 * LeetCode 3480. Maximize Subarrays After Removing One Conflicting Pair
 */
fun maxSubarrays(n: Int, conflictingPairs: Array<IntArray>): Long {
  val pairCount = conflictingPairs.size

  // Bucket conflicts by their smaller endpoint.
  val pairsStartingAtValue = Array(n + 2) { mutableListOf<Pair<Int, Int>>() }

  for ((pairId, pair) in conflictingPairs.withIndex()) {
    var leftEndpoint = pair[0]
    var rightEndpoint = pair[1]
    if (leftEndpoint > rightEndpoint) {
      val temp = leftEndpoint
      leftEndpoint = rightEndpoint
      rightEndpoint = temp
    }
    pairsStartingAtValue[leftEndpoint].add(rightEndpoint to pairId)
  }

  // Sentinel value indicating no blocking right endpoint.
  val beyondArrayRight = n + 1

  var earliestBlockingRight = beyondArrayRight
  var earliestBlockingPairId = -1

  var secondBlockingRight = beyondArrayRight
  var secondBlockingPairId = -1

  fun considerConflict(rightEndpoint: Int, pairId: Int) {
    if (rightEndpoint < earliestBlockingRight ||
      (rightEndpoint == earliestBlockingRight && pairId < earliestBlockingPairId)
    ) {
      secondBlockingRight = earliestBlockingRight
      secondBlockingPairId = earliestBlockingPairId

      earliestBlockingRight = rightEndpoint
      earliestBlockingPairId = pairId
    } else if (pairId != earliestBlockingPairId &&
      (rightEndpoint < secondBlockingRight ||
        (rightEndpoint == secondBlockingRight && pairId < secondBlockingPairId))
    ) {
      secondBlockingRight = rightEndpoint
      secondBlockingPairId = pairId
    }
  }

  val extraCountIfRemoved = LongArray(pairCount)
  var baseValidCount = 0L

  // Sweep left boundary from right to left.
  for (leftIndex in n downTo 1) {
    for ((rightEndpoint, pairId) in pairsStartingAtValue[leftIndex]) {
      considerConflict(rightEndpoint, pairId)
    }

    val firstForbiddenRight = earliestBlockingRight
    val secondForbiddenRight = secondBlockingRight

    val maxRightWithoutFirst = if (firstForbiddenRight == beyondArrayRight) n else firstForbiddenRight - 1
    baseValidCount += (maxRightWithoutFirst - leftIndex + 1)

    if (firstForbiddenRight != beyondArrayRight) {
      val maxRightWithoutSecond = if (secondForbiddenRight == beyondArrayRight) n else secondForbiddenRight - 1
      val gainHere = (maxRightWithoutSecond - maxRightWithoutFirst).toLong()
      if (gainHere > 0) extraCountIfRemoved[earliestBlockingPairId] += gainHere
    }
  }

  val bestExtra = extraCountIfRemoved.maxOrNull() ?: 0L
  return baseValidCount + bestExtra
}

