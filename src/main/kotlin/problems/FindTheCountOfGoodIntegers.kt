package problems

import kotlin.math.pow

/**
 * Solves the "Find the Count of Good Integers" problem. LeetCode 3272.
 *
 * A number is "good" if its digits can be rearranged to form a "k-palindromic" number.
 * A number is "k-palindromic" if it's a palindrome and divisible by k.
 * The goal is to count the number of n-digit positive integers that are "good".
 * Leading zeros are not allowed in the original number or the rearranged palindrome.
 */

// Helper function for calculating base^exp using Long.
// Handles potential overflow for large results, but safe for base=10 and small exp relevant here.
private fun longPow(base: Long, exp: Int): Long {
    var result = 1L
    // Simple loop is sufficient and safe for small exponents (max 5 for n=10)
    repeat(exp) {
        // Check for potential overflow if base or exp were very large
        if (result > Long.MAX_VALUE / base) {
            return Long.MAX_VALUE // Indicate overflow
        }
        result *= base
    }
    return result
}

// Factorials array, to be initialized in the main function.
private lateinit var factorials: LongArray

/**
 * Calculates the number of distinct permutations of a multiset of digits.
 * Formula: totalDigits! / (count[0]! * count[1]! * ... * count[9]!)
 * Uses precomputed factorials and Long to handle potentially large numbers.
 *
 * @param counts An array where counts[i] is the frequency of digit i.
 * @param totalDigits The total number of digits (sum of counts, should equal n or n-1).
 * @return The number of permutations, or Long.MAX_VALUE if overflow occurs.
 */
private fun calculatePermutations(counts: IntArray, totalDigits: Int): Long {
    // Base case: 0 digits, 1 permutation (the empty arrangement)
    if (totalDigits == 0) return 1L
    // Basic validation
    if (totalDigits < 0 || totalDigits >= factorials.size) {
        return 0L // Invalid input or index out of bounds for factorials
    }

    val numerator = factorials[totalDigits]
    var denominator = 1L

    for (count in counts) {
        // Skip if count is 0 or 1 (0! = 1, 1! = 1)
        if (count > 1) {
            // Check if count is within bounds for precomputed factorials
            if (count >= factorials.size) return 0L // Invalid count

            val factCount = factorials[count]
            // Check for potential overflow before multiplying denominator
            if (factCount > 0 && denominator > Long.MAX_VALUE / factCount) {
                return Long.MAX_VALUE // Indicate denominator overflow
            }
            denominator *= factCount
        }
    }

    // Avoid division by zero (denominator should be >= 1)
    if (denominator == 0L) return Long.MAX_VALUE // Should not happen if factorials[0]=1

    // Perform the final division
    return numerator / denominator
}

/**
 * Finds the count of n-digit "good" integers.
 *
 * @param n The required number of digits. Constraints: 1 <= n <= 10.
 * @param k The divisor for k-palindromic check. Constraints: 1 <= k <= 9.
 * @return The count of good integers as a Long.
 */
fun countGoodIntegers(n: Int, k: Int): Long {
    // Step 1: Precompute factorials up to n. Max n=10, so 10! fits in Long.
    factorials = LongArray(n + 1)
    factorials[0] = 1L
    for (i in 1..n) {
        // Check for potential overflow during factorial calculation (safe for n<=10)
        if (factorials[i - 1] > Long.MAX_VALUE / i) {
            factorials[i] = Long.MAX_VALUE // Mark overflow (won't happen for n=10)
        } else {
            factorials[i] = factorials[i - 1] * i
        }
    }

    // Step 2: Generate potential k-palindromic numbers and collect their unique digit multisets.

    // The first half of an n-digit palindrome determines the entire number.
    // Length of the first half (including middle digit if n is odd).
    val halfLen = (n + 1) / 2

    // Calculate the numerical range for the first half.
    // It must be a number with 'halfLen' digits (no leading zeros).
    // Smallest: 1 followed by halfLen-1 zeros (10^(halfLen-1)). Except if halfLen=1, then start=1.
    // Largest: halfLen nines (10^halfLen - 1).
    val start = if (halfLen == 1) 1L else longPow(10L, halfLen - 1)
    val end = longPow(10L, halfLen) - 1

    // Use a Set to store unique digit multisets found.
    // Represent each multiset by its sorted digit string for easy comparison and uniqueness.
    val uniqueDigitMultisets = mutableSetOf<String>()

    // Iterate through all possible first halves (as numbers).
    for (prefixNum in start..end) {
        val prefixStr = prefixNum.toString()

        // Construct the full palindrome string based on the prefix.
        val suffixStr = if (n % 2 == 0) {
            // Even n: Reverse the whole prefix. e.g., prefix=12 -> suffix=21 -> palindrome=1221
            prefixStr.reversed()
        } else {
            // Odd n: Reverse the prefix excluding its last char (the middle digit).
            // e.g., prefix=123 -> suffix=21 -> palindrome=12321
            prefixStr.dropLast(1).reversed()
        }
        val palindromeStr = prefixStr + suffixStr

        // Convert palindrome string to Long for divisibility check.
        // Use toLongOrNull for safety, though palindromeStr should always be valid digits.
        val palindromeNum = palindromeStr.toLongOrNull() ?: continue // Skip if conversion fails

        // Check if this palindrome is divisible by k.
        if (palindromeNum % k == 0L) {
            // It's a k-palindromic number. Get its digit multiset signature.
            // Sorting the characters gives a canonical representation of the multiset.
            val sortedDigits = palindromeStr.toCharArray().sortedArray().joinToString("")
            uniqueDigitMultisets.add(sortedDigits)
        }
    }

    // Step 3: For each unique multiset, calculate the count of valid n-digit numbers
    // that can be formed using those digits (no leading zeros).
    var totalGoodCount = 0L

    for (multisetString in uniqueDigitMultisets) {
        // Determine the frequency of each digit (0-9) in the current multiset.
        val counts = IntArray(10)
        for (char in multisetString) {
            // Increment count for the digit represented by char.
            counts[char - '0']++
        }

        // Calculate the total number of permutations of the n digits in the multiset.
        val totalPerms = calculatePermutations(counts, n)
        // Basic check if permutation calculation indicated overflow
        if (totalPerms == Long.MAX_VALUE) {
            // Handle overflow case appropriately if necessary, though unlikely for n=10.
            // Depending on problem constraints, could return error or max value.
            // Assuming results fit in Long based on constraints.
        }

        // Calculate the number of permutations that start with '0'.
        // These are invalid n-digit numbers and must be subtracted.
        var zeroLeadingPerms = 0L
        // Permutations can only start with '0' if the multiset contains at least one '0'.
        if (counts[0] > 0) {
            // Create a count array representing the remaining n-1 digits after placing '0' first.
            val countsWithoutOneZero = counts.clone()
            countsWithoutOneZero[0]-- // Decrement the count of '0'

            // Calculate permutations for the remaining n-1 digits.
            zeroLeadingPerms = calculatePermutations(countsWithoutOneZero, n - 1)
            if (zeroLeadingPerms == Long.MAX_VALUE) {
                // Handle overflow if necessary
            }
        }

        // The number of valid n-digit numbers for this multiset is totalPerms - zeroLeadingPerms.
        val validPerms = totalPerms - zeroLeadingPerms

        // Add the count of valid numbers for this multiset to the overall total.
        totalGoodCount += validPerms
    }

    return totalGoodCount
} 