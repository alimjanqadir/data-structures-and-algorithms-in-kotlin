package problems

/**
 * Finds two numbers such that they add up to a specific target number using brute force.
 *
 * @param numbers An array of integers sorted in non-decreasing order.
 * @param target The target sum.
 * @return An array containing the 1-based indices of the two numbers.
 */
fun twoSumBruteForce(numbers: IntArray, target: Int): IntArray {
  val n = numbers.size
  // Iterate through each element except the last one
  for (i in 0 until n - 1) {
    // Iterate from the next element to the end
    for (j in i + 1 until n) {
      // Check if the sum equals the target
      if (numbers[i] + numbers[j] == target) {
        // Return 1-based indices
        return intArrayOf(i + 1, j + 1)
      }
    }
  }
  // If no pair is found, return an empty array
  return intArrayOf()
}

/**
 * Finds two numbers using the two-pointer technique.
 *
 * @param numbers An array of integers sorted in non-decreasing order.
 * @param target The target sum.
 * @return An array containing the 1-based indices of the two numbers.
 */
fun twoSumTwoPointers(numbers: IntArray, target: Int): IntArray {
  // Initialize pointers at the start and end of the array
  var left = 0
  var right = numbers.size - 1

  // Loop until the pointers meet
  while (left < right) {
    val currentSum = numbers[left] + numbers[right]
    // If the current sum matches the target, return the indices
    if (currentSum == target) {
      return intArrayOf(left + 1, right + 1)
    }
    // If current sum is less than target, move the left pointer to the right
    if (currentSum < target) {
      left++
    } else {
      // If current sum is greater than target, move the right pointer to the left
      right--
    }
  }
  // Return an empty array if no solution is found
  return intArrayOf()
}

/**
 * Finds two numbers using functional programming concepts.
 *
 * @param numbers An array of integers sorted in non-decreasing order.
 * @param target The target sum.
 * @return An array containing the 1-based indices of the two numbers.
 */
fun twoSumFunctional(numbers: IntArray, target: Int): IntArray {
  // Recursive inner function to maintain immutability
  tailrec fun search(left: Int, right: Int): IntArray {
    // Base case: pointers have crossed
    if (left >= right) return intArrayOf()
    val currentSum = numbers[left] + numbers[right]
    return when {
      currentSum == target -> intArrayOf(left + 1, right + 1)
      currentSum < target -> search(left + 1, right)
      else -> search(left, right - 1)
    }
  }
  // Start the recursive search
  return search(0, numbers.size - 1)
}

fun twoSumHashMap(nums: IntArray, target: Int): IntArray {
  val complementMap = mutableMapOf<Int, Int>()
  nums.forEachIndexed { index, num ->
    complementMap[target - num]?.let { return intArrayOf(it, index) }
    complementMap[num] = index
  }
  throw IllegalArgumentException("No two sum solution")
}

