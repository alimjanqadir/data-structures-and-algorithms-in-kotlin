package problems

import kotlin.math.pow // Not actually needed, but shows awareness

/**
 * Calculates the sum of XOR totals for all subsets of the input list 'nums'.
 *
 * The XOR total of a list is the bitwise XOR of all its elements, or 0 if the list is empty.
 *
 * Example:
 * nums = [1, 3]
 * Subsets: [], [1], [3], [1, 3]
 * XOR Totals: 0, 1, 3, 2
 * Sum = 0 + 1 + 3 + 2 = 6
 *
 * The solution uses a mathematical insight:
 * Consider the k-th bit. If at least one number in 'nums' has the k-th bit set,
 * then exactly half of the subsets (2^(n-1)) will have their XOR total's k-th bit set.
 * The contribution of the k-th bit to the total sum is therefore (1 shl k) * (1 shl (n-1)).
 * Summing over all bits k where the bitwise OR of 'nums' has the k-th bit set,
 * we get: Sum = (bitwise_OR_of_nums) * (1 shl (n-1)).
 *
 * Constraints: 1 <= nums.size <= 12
 */
fun subsetXORSum(nums: IntArray): Int {
    val n = nums.size
    // Note: Constraints guarantee 1 <= n <= 12, so n is never 0.

    // Calculate the bitwise OR of all elements using fold.
    // 'or' is the infix function for bitwise OR in Kotlin.
    // Start with 0, then OR each number with the accumulator.
    val orTotal = nums.fold(0) { accumulator, number ->
        accumulator or number
    }

    // Calculate the multiplier 2^(n-1) using bitwise left shift 'shl'.
    // This is more efficient than using Math.pow or Double conversions.
    val multiplier = 1 shl (n - 1)

    // The final sum is the bitwise OR total multiplied by 2^(n-1).
    return orTotal * multiplier
}
