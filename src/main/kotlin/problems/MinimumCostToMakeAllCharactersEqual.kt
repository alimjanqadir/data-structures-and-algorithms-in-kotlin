package problems

import kotlin.math.min // Use min directly as it works with Int/Long

/**
 * Calculates the minimum cost to make all characters in a binary string equal.
 *
 * The cost is determined by summing the minimum cost required to resolve each adjacent character difference.
 * For a difference at index `i` (between `s[i]` and `s[i+1]`), the two options are:
 * 1. Flip prefix `[0..i]` with cost `i + 1`.
 * 2. Flip suffix `[i+1..n-1]` with cost `n - (i + 1)`.
 * We take the minimum of these two costs for each difference.
 *
 * @param s The input binary string (0-indexed).
 * @return The minimum cost as a Long to make all characters equal.
 */
fun minimumCost(s: String): Long {
  val n = s.length
  // If the string has 0 or 1 characters, it's already uniform. Cost is 0.
  if (n <= 1) {
    return 0L
  }

  // Use sumOf for a functional and idiomatic approach.
  // Iterate through the indices representing the boundary between characters.
  // The relevant boundaries are from index 0 up to n-2.
  return (0 until n - 1).sumOf { i ->
    // Check if there is a difference between adjacent characters.
    if (s[i] != s[i+1]) {
      // Cost of flipping the prefix ending at index i.
      val costPrefix = (i + 1).toLong()
      // Cost of flipping the suffix starting at index i + 1.
      // Equivalent to n - (i + 1)
      val costSuffix = (n - i - 1).toLong()

      // Add the minimum of the two possible costs for this boundary.
      // minOf is explicit for Long, but min works polymorphically.
      min(costPrefix, costSuffix)
    } else {
      // If characters are the same, this boundary requires no cost to resolve.
      0L
    }
  }
}

// Example Usage:
fun main() {
  val s1 = "0011"
  println("Input: \"$s1\", Output: ${minimumCost(s1)}") // Output: 2

  val s2 = "010101"
  println("Input: \"$s2\", Output: ${minimumCost(s2)}") // Output: 9

  val s3 = "1111"
  println("Input: \"$s3\", Output: ${minimumCost(s3)}") // Output: 0

  val s4 = "00010"
  println("Input: \"$s4\", Output: ${minimumCost(s4)}") // Output: 3

  val s5 = "1010"
  println("Input: \"$s5\", Output: ${minimumCost(s5)}") // Output: 4

  val s6 = "111000"
  println("Input: \"$s6\", Output: ${minimumCost(s6)}") // Output: 3
}