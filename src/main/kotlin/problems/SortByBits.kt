package problems

/**
 * Problem 1356: Sort Integers by Number of 1 Bits
 * Time Complexity: O(n log n) where n is the number of elements in the array
 * Space Complexity: O(n) for the sorted result
 */

/**
 * Sorts an array of integers by the number of 1 bits in their binary representation.
 * If two numbers have the same number of 1 bits, they are sorted by their value.
 *
 * @param arr The input array of integers
 * @return The sorted array
 */
fun sortByBits(arr: IntArray): IntArray {
  return arr.sortedWith(
    compareBy<Int> { Integer.bitCount(it) }
      .thenBy { it }
  ).toIntArray()
}
