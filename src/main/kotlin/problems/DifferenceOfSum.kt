package problems

/**
 * Calculates the absolute difference between the sum of all elements in the array
 * and the sum of all digits of those elements.
 *
 * @param nums An array of positive integers.
 * @return The absolute difference between the element sum and the digit sum.
 */
fun differenceOfSums(nums: IntArray): Int {
  // Calculate the sum of all elements in the array using the built-in sum() function
  val elementSum: Int = nums.sum()

  // Calculate the sum of all digits in the array
  // For each number, convert it to a string to access individual digits
  // Then, convert each character digit back to an integer and sum them up
  val digitSum: Int = nums.sumOf { num ->
    // Convert the number to its string representation
    val numStr: String = num.toString()

    // Sum the integer values of each character digit
    numStr.sumOf { digitChar ->
      // Convert the character digit to its integer value
      digitChar - '0'
    }
  }

  // Compute the absolute difference between elementSum and digitSum
  val difference: Int = kotlin.math.abs(elementSum - digitSum)

  return difference
}

fun differenceOfSumsFunctional(nums: IntArray): Int {
  val elementSum = nums.sum()
  val digitSum = nums.flatMap { it.toString().map { char -> char - '0' } }.sum()
  return kotlin.math.abs(elementSum - digitSum)
}

fun main() {
  // Test Case 1: Example 1
  val nums1 = intArrayOf(1, 15, 6, 3)
  assert(differenceOfSums(nums1) == 9) { "Test Case 1 Failed" }

  // Test Case 2: Example 2
  val nums2 = intArrayOf(1, 2, 3, 4)
  assert(differenceOfSums(nums2) == 0) { "Test Case 2 Failed" }

  // Test Case 3: Single Element
  val nums3 = intArrayOf(123)
  assert(differenceOfSums(nums3) == 117) { "Test Case 3 Failed" }

  // Test Case 4: Maximum Values
  val nums4 = IntArray(2000) { 2000 }
  assert(differenceOfSums(nums4) == 3996000) { "Test Case 4 Failed" }

  // Test Case 5: All Single-Digit Numbers
  val nums5 = intArrayOf(9, 8, 7)
  // Element Sum: 24
  // Digit Sum: 9 + 8 + 7 = 24
  // Difference: 0
  assert(differenceOfSums(nums5) == 0) { "Test Case 5 Failed" }

  // Test Case 6: Mixed Digit Counts
  val nums6 = intArrayOf(10, 20, 30)
  // Element Sum: 60
  // Digit Sum: (1 + 0) + (2 + 0) + (3 + 0) = 6
  // Difference: 54
  assert(differenceOfSums(nums6) == 54) { "Test Case 6 Failed" }

  // Test Case 7: Large Numbers with Multiple Digits
  val nums7 = intArrayOf(9999, 1001, 23)
  // Element Sum: 9999 + 1001 + 23 = 11023
  // Digit Sum: (9+9+9+9) + (1+0+0+1) + (2+3) = 36 + 2 + 5 = 43
  // Difference: 10980
  assert(differenceOfSums(nums7) == 10980) { "Test Case 7 Failed" }

  println("All test cases passed.")
}