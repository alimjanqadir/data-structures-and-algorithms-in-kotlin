package problems

import kotlin.math.abs

fun main(args: Array<String>) {
  val arrayA = arrayOf(7, 4, 1, 10)
  val arrayB = arrayOf(4, 5, 8, 7)
  val target = 19

  val closestPair = closestSumPairs(arrayA, arrayB, target)
  println(closestPair)
}

@Suppress("SameParameterValue")
private fun closestSumPairs(arrayA: Array<Int>, arrayB: Array<Int>, target: Int): Pair<Int, Int> {
  if (target == 0)
    throw IllegalAccessException("Target equals zero!")

  val sortedArrayA = arrayA.sortedArray()
  val sortedArrayB = arrayB.sortedArray()

  var i = 0
  var j = sortedArrayA.size - 1
  var closestPair: Pair<Int, Int> = Pair(0, 0)
  var smallestDifference = Int.MAX_VALUE


  while (i < sortedArrayA.size && j >= 0) {
    val leftEdge = sortedArrayB[i]
    val rightEdge = sortedArrayA[j]
    val currentDifference = rightEdge + leftEdge - target

    if (abs(currentDifference) == 0) {
      return Pair(leftEdge, rightEdge)
    }

    if (currentDifference < 0)
      i += 1
    else
      j -= 1

    if (abs(currentDifference) < abs(smallestDifference)) {
      smallestDifference = currentDifference
      closestPair = Pair(leftEdge, rightEdge)
    }
  }

  return closestPair
}