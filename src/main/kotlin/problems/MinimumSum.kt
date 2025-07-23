import kotlin.math.min

/**
 * Calculates the minimum possible sum of a k-avoiding array of length n.
 *
 * A k-avoiding array contains distinct positive integers such that no
 * two distinct elements sum to k.
 *
 * To minimize the sum, we should greedily select the smallest available
 * positive integers (1, 2, 3, ...).
 *
 * The constraint is that if we include a number `x` in the array, we cannot
 * include `k - x` (if `x != k - x`). Since we want the minimum sum, if we
 * have a choice between `x` and `k - x`, we should always pick the smaller one.
 *
 * This means we can safely pick all integers from 1 up to `k / 2`.
 * Let `midpoint = k / 2`. We can pick `1, 2, ..., midpoint`.
 *
 * If we still need more numbers after picking `1` through `midpoint`,
 * we must avoid the numbers that would sum to `k` with those we've already picked.
 * Specifically, we've avoided `k-1, k-2, ..., k-midpoint`.
 * The next smallest available integer we can pick is `k`.
 * So, we continue picking `k, k+1, k+2, ...` until we have `n` numbers in total.
 *
 * This leads to an O(1) mathematical solution.
 *
 * @param n The desired length of the array.
 * @param k The target sum to avoid.
 * @return The minimum possible sum.
 */
fun minimumSum(n: Int, k: Int): Int {
  // Calculate the largest number x <= k/2. We can safely pick all numbers from 1 to midpoint.
  val midpoint = k / 2

  // Determine how many numbers we pick from the range [1, midpoint].
  // This is either n (if n <= midpoint) or midpoint itself.
  val count1 = min(n, midpoint)

  // Calculate the sum of the first 'count1' natural numbers (1 + 2 + ... + count1).
  // Use Long for intermediate sum calculation to prevent potential overflow,
  // although Int is sufficient given the constraints (n, k <= 50).
  // Formula for sum of first m integers: m * (m + 1) / 2
  val sum1 = count1.toLong() * (count1 + 1) / 2

  // Calculate how many more numbers we need after picking the first 'count1'.
  val remainingCount = n - count1
  var sum2 = 0L // Sum of the second batch of numbers (starting from k)

  // If we still need more numbers (remainingCount > 0):
  if (remainingCount > 0) {
    // We need to pick 'remainingCount' numbers.
    // The smallest available numbers now start from k.
    // The sequence is: k, k+1, k+2, ..., k + remainingCount - 1.

    // Calculate the sum of this arithmetic series.
    // Formula: count * (first + last) / 2
    val firstNumInSeries = k.toLong()
    val lastNumInSeries = k.toLong() + remainingCount - 1
    sum2 = remainingCount.toLong() * (firstNumInSeries + lastNumInSeries) / 2
  }

  // The total minimum sum is the sum of the two parts.
  // The result is guaranteed by the constraints to fit within an Int.
  return (sum1 + sum2).toInt()
}

// Example Usage:
