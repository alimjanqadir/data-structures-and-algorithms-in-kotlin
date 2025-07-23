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

