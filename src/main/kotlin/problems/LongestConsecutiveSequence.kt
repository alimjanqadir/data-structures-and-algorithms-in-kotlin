package problems

/**
 * Brute Force Approach
 * Time: O(n^2)
 * Space: O(1)
 */
fun longestConsecutiveBruteForce(nums: IntArray): Int {
  if (nums.isEmpty()) return 0
  var maxLength = 1

  for (num in nums) {
    var currentNum = num
    var currentLength = 1

    while (nums.contains(currentNum + 1)) {
      currentNum++
      currentLength++
    }
    maxLength = maxOf(maxLength, currentLength)
  }
  return maxLength
}

/**
 * Optimized Solution using HashSet
 * Time: O(n)
 * Space: O(n)
 */
fun longestConsecutive(nums: IntArray): Int {
  if (nums.isEmpty()) return 0

  // Convert array to HashSet for O(1) lookups
  val numSet = nums.toHashSet()
  var maxLength = 1

  for (num in numSet) {
    // Only start counting if this is the start of a sequence
    if (!numSet.contains(num - 1)) {
      var currentNum = num
      var currentLength = 1

      while (numSet.contains(currentNum + 1)) {
        currentNum++
        currentLength++
      }
      maxLength = maxOf(maxLength, currentLength)
    }
  }
  return maxLength
}

/**
 * Functional Solution using sequences
 * Time: O(n)
 * Space: O(n)
 */
fun longestConsecutiveFunctional(nums: IntArray): Int =
  if (nums.isEmpty()) 0
  else nums.toSet().let { set ->
    set.filter { num -> !set.contains(num - 1) }
      .maxOf { start ->
        generateSequence(start) { if (set.contains(it + 1)) it + 1 else null }
          .count()
      }
  }

fun main() {
  val testCases = listOf(
    intArrayOf(100, 4, 200, 1, 3, 2),
    intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1),
    intArrayOf(),
    intArrayOf(1),
    intArrayOf(1, 1, 2, 2, 3, 3),
    intArrayOf(-5, -4, -3, -2, 0, 1)
  )

  val expectedResults = listOf(4, 9, 0, 1, 3, 4)

  testCases.zip(expectedResults).forEachIndexed { index, (input, expected) ->
    val resultBruteForce = longestConsecutiveBruteForce(input)
    val resultOptimized = longestConsecutive(input)
    val resultFunctional = longestConsecutiveFunctional(input)

    println("Test case ${index + 1}:")
    println("Input: ${input.contentToString()}")
    println("Expected: $expected")
    println("Brute Force result: $resultBruteForce")
    println("Optimized result: $resultOptimized")
    println("Functional result: $resultFunctional")

    assert(resultBruteForce == expected) { "Brute Force solution failed for test case ${index + 1}" }
    assert(resultOptimized == expected) { "Optimized solution failed for test case ${index + 1}" }
    assert(resultFunctional == expected) { "Functional solution failed for test case ${index + 1}" }
    assert(resultBruteForce == resultOptimized && resultOptimized == resultFunctional) { "Results don't match for test case ${index + 1}" }

    println("All assertions passed for test case ${index + 1}")
    println()
  }

  println("All test cases passed successfully!")
}