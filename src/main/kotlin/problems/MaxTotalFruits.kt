package problems

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun maxTotalFruits(
  fruits: Array<IntArray>,
  startPos: Int,
  k: Int
): Int {

  val n = fruits.size
  val positions = IntArray(n)
  val amounts = IntArray(n)
  for (idx in 0 until n) {
    positions[idx] = fruits[idx][0]
    amounts[idx] = fruits[idx][1]
  }

  /* prefixAmount[i] = Σ amounts[0‥i-1] (1-based) */
  val prefixAmount = LongArray(n + 1)
  for (idx in 0 until n) prefixAmount[idx + 1] = prefixAmount[idx] + amounts[idx]

  fun harvest(fromInclusive: Int, toInclusive: Int): Long =
    prefixAmount[toInclusive + 1] - prefixAmount[fromInclusive]

  var leftIdx = 0
  var best: Long = 0

  /* rightIdx sweeps once from left to right */
  for (rightIdx in 0 until n) {

    /* shrink window until it fits into k steps */
    while (leftIdx <= rightIdx) {
      val leftPos = positions[leftIdx]
      val rightPos = positions[rightIdx]

      val segmentLen = rightPos - leftPos
      val reachNearEnd = min(abs(startPos - leftPos), abs(rightPos - startPos))
      val minimalSteps = segmentLen + reachNearEnd

      if (minimalSteps <= k) break
      leftIdx += 1 // window too wide – move the left edge rightwards
    }

    if (leftIdx <= rightIdx) {
      best = max(best, harvest(leftIdx, rightIdx))
    }
  }

  return best.toInt()
}

