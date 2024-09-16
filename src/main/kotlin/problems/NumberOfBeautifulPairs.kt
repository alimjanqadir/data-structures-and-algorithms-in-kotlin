import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

// Calculates the Greatest Common Divisor (GCD) of two numbers using Euclidean algorithm
private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

// Extracts the leading digit of a number using logarithmic approach
private fun leadingDigitOf(x: Int): Int {
    return floor(x / 10.0.pow(floor(log10(x.toDouble())))).toInt()
}

// Extracts the last digit of a number using modulo operation
private fun lastDigitOf(x: Int): Int {
    return x % 10
}

// Checks if two numbers are coprime (their GCD is 1)
private fun isCoprime(a: Int, b: Int): Boolean {
    return gcd(a, b) == 1
}

// Counts the number of beautiful pairs in the given array
// A beautiful pair is a pair of indices (i, j) where i < j,
// and the product of the leading digit of nums[i] and the last digit of nums[j] is coprime
fun countBeautifulPairs(nums: IntArray): Int {
    val leadingDigitCount = IntArray(10)
    // Use fold to iterate through the array and accumulate the result
    return nums.fold(0) { res, num ->
        // Count beautiful pairs for the current number
        val pairsCount =
                (1..9)
                .filter { leadingDigit -> isCoprime(lastDigitOf(num), leadingDigit) }
                .sumOf { coPrimeLeadingDigit -> leadingDigitCount[coPrimeLeadingDigit] }
        // Update the count of leading digits
        leadingDigitCount[leadingDigitOf(num)]++
        // Accumulate the result
        res + pairsCount
    }
}

fun main() {
    // Example 1
    val nums1 = intArrayOf(2, 5, 1, 4)
    println("Example 1:")
    println("Input: ${nums1.contentToString()}")
    println("Steps:")
    var result = countBeautifulPairs(nums1)
    // i = 0, j = 1: (2, 5) is a beautiful pair, count = 1
    // i = 0, j = 2: (2, 1) is not a beautiful pair, count = 1
    // i = 0, j = 3: (2, 4) is not a beautiful pair, count = 1
    // i = 1, j = 2: (5, 1) is a beautiful pair, count = 2
    // i = 1, j = 3: (5, 4) is a beautiful pair, count = 3
    // i = 2, j = 3: (1, 4) is a beautiful pair, count = 4
    println("Output: $result")
    println()

    // Example 2
    val nums2 = intArrayOf(3, 9, 15, 21)
    println("Example 2:")
    println("Input: ${nums2.contentToString()}")
    println("Steps:")
    result = countBeautifulPairs(nums2)
    // i = 0, j = 1: (3, 9) is a beautiful pair, count = 1
    // i = 0, j = 2: (3, 15) is a beautiful pair, count = 2
    // i = 0, j = 3: (3, 21) is a beautiful pair, count = 3
    // i = 1, j = 2: (9, 15) is a beautiful pair, count = 4
    // i = 1, j = 3: (9, 21) is a beautiful pair, count = 5
    // i = 2, j = 3: (15, 21) is a beautiful pair, count = 6
    println("Output: $result")
    println()

    // Example 3
    val nums3 = intArrayOf(1, 1, 1, 1)
    println("Example 3:")
    println("Input: ${nums3.contentToString()}")
    println("Steps:")
    result = countBeautifulPairs(nums3)
    // i = 0, j = 1: (1, 1) is not a beautiful pair, count = 0
    // i = 0, j = 2: (1, 1) is not a beautiful pair, count = 0
    // i = 0, j = 3: (1, 1) is not a beautiful pair, count = 0
    // i = 1, j = 2: (1, 1) is not a beautiful pair, count = 0
    // i = 1, j = 3: (1, 1) is not a beautiful pair, count = 0
    // i = 2, j = 3: (1, 1) is not a beautiful pair, count = 0
    println("Output: $result")
}
