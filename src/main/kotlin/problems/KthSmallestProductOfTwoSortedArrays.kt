package problems

import kotlin.math.max
import kotlin.math.min

/**
 * Finds the `targetRank`-th smallest product of two sorted arrays.
 *
 * See original commentary for the full explanation of the approach.
 */
fun kthSmallestProduct(
  firstSortedNumbers: IntArray,
  secondSortedNumbers: IntArray,
  targetRank: Long
): Long {
  val firstArraySize = firstSortedNumbers.size
  val secondArraySize = secondSortedNumbers.size

  // Extreme products formed by combining the extreme values of the two arrays.
  val productLowestLowest  = firstSortedNumbers[0].toLong() * secondSortedNumbers[0].toLong()
  val productLowestHighest = firstSortedNumbers[0].toLong() * secondSortedNumbers[secondArraySize - 1].toLong()
  val productHighestLowest = firstSortedNumbers[firstArraySize - 1].toLong() * secondSortedNumbers[0].toLong()
  val productHighestHighest =
    firstSortedNumbers[firstArraySize - 1].toLong() * secondSortedNumbers[secondArraySize - 1].toLong()

  var smallestPossibleProduct = min(
    min(productLowestLowest, productLowestHighest),
    min(productHighestLowest, productHighestHighest)
  )
  var largestPossibleProduct = max(
    max(productLowestLowest, productLowestHighest),
    max(productHighestLowest, productHighestHighest)
  )
  var resultProduct = largestPossibleProduct

  while (smallestPossibleProduct <= largestPossibleProduct) {
    val midProduct =
      smallestPossibleProduct + (largestPossibleProduct - smallestPossibleProduct) / 2
    val productsNotExceedingMid =
      countProductsLessOrEqual(midProduct, firstSortedNumbers, secondSortedNumbers)

    if (productsNotExceedingMid >= targetRank) {
      // `midProduct` is a potential answer; try to find a smaller one.
      resultProduct = midProduct
      largestPossibleProduct = midProduct - 1
    } else {
      // Too few products ≤ midProduct; search higher.
      smallestPossibleProduct = midProduct + 1
    }
  }
  return resultProduct
}

/**
 * Counts the number of products `firstSortedNumbers[i] * secondSortedNumbers[j]`
 * that are ≤ `thresholdProduct`.
 *
 * Time complexity: O(n · log m)
 */
private fun countProductsLessOrEqual(
  thresholdProduct: Long,
  firstSortedNumbers: IntArray,
  secondSortedNumbers: IntArray
): Long {
  var totalQualifiedProducts = 0L
  val secondArraySize = secondSortedNumbers.size

  for (firstArrayElementValue in firstSortedNumbers) {
    val firstArrayElement = firstArrayElementValue.toLong()

    when {
      firstArrayElement == 0L -> {
        if (thresholdProduct >= 0) {
          totalQualifiedProducts += secondArraySize
        }
      }

      firstArrayElement > 0L -> {
        // Need: firstArrayElement * secondArrayElement ≤ thresholdProduct
        var leftIndex = 0
        var rightIndex = secondArraySize - 1
        var qualifiedCountForCurrentElement = 0

        while (leftIndex <= rightIndex) {
          val middleIndex = leftIndex + (rightIndex - leftIndex) / 2
          if (firstArrayElement * secondSortedNumbers[middleIndex] <= thresholdProduct) {
            qualifiedCountForCurrentElement = middleIndex + 1
            leftIndex = middleIndex + 1
          } else {
            rightIndex = middleIndex - 1
          }
        }
        totalQualifiedProducts += qualifiedCountForCurrentElement
      }

      else -> { // firstArrayElement < 0
        // Need: firstArrayElement * secondArrayElement ≤ thresholdProduct
        // ⇒ secondArrayElement ≥ thresholdProduct / firstArrayElement
        var leftIndex = 0
        var rightIndex = secondArraySize - 1
        var qualifiedCountForCurrentElement = 0

        while (leftIndex <= rightIndex) {
          val middleIndex = leftIndex + (rightIndex - leftIndex) / 2
          if (firstArrayElement * secondSortedNumbers[middleIndex] <= thresholdProduct) {
            qualifiedCountForCurrentElement =
              secondArraySize - middleIndex
            rightIndex = middleIndex - 1
          } else {
            leftIndex = middleIndex + 1
          }
        }
        totalQualifiedProducts += qualifiedCountForCurrentElement
      }
    }
  }
  return totalQualifiedProducts
}
