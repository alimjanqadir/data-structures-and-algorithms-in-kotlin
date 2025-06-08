package problems

/**
 * Problem: 2894. Difference of Sums
 * 
 * This function calculates the difference between the sum of numbers not divisible by m and the sum of numbers divisible by m from 1 to n.
 * 
 * @param n The upper bound of the number range (inclusive)
 * @param m The divisor to check against
 * @return The difference (sum of non-divisible numbers) - (sum of divisible numbers)
 */
fun differenceOfSums(n: Int, m: Int): Int {
  // Sum of all numbers from 1 to n
  val totalSum = n * (n + 1) / 2

  // Count of multiples of m up to n
  val multipleCount = n / m

  // Sum of multiples of m up to n: m + 2m + … + multipleCount·m
  val multiplesSum = m * multipleCount * (multipleCount + 1) / 2

  // The difference is (sum of all) - 2*(sum of multiples)
  // This works because: (sum of non-multiples) - (sum of multiples) = totalSum - 2*(sum of multiples)
  return totalSum - 2 * multiplesSum
}
