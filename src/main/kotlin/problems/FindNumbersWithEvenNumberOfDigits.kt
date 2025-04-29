import kotlin.math.log10

/**
 * LeetCode 1295. Find Numbers with Even Number of Digits
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */

fun findNumbersWithEvenNumberOfDigits(nums: IntArray): Int =
    nums.count { number ->
        // digits = ⌊log₁₀(number)⌋ + 1   (number ≥ 1 by constraints)
        val digitCount = log10(number.toDouble()).toInt() + 1
        digitCount % 2 == 0
    }
