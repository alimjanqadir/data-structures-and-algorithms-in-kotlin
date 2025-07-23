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

