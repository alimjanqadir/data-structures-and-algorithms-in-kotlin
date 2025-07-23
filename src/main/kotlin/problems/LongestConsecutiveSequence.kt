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

