package problems

/**
 * 3567. Maximum Nesting Depth
 * LeetCode problem: Easy
 *
 * Returns the maximum nesting depth of parentheses for each group in a string.
 * Groups are separated by outermost parentheses pairs.
 *
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the result list
 *
 * @param s String containing groups of balanced parentheses separated by outermost pairs
 * @return List of maximum depths for each group
 */
fun maxDepthAfterSplit(seq: String): IntArray {
  val result = ArrayList<Int>()
  var currentDepth = 0
  var maxDepth = 0
  var groupStarted = false

  for (char in seq) {
    when (char) {
      '(' -> {
        if (!groupStarted) {
          groupStarted = true
          currentDepth = 0
          maxDepth = 0
        }
        currentDepth += 1
        maxDepth = maxOf(maxDepth, currentDepth)
      }
      ')' -> {
        currentDepth -= 1
        if (currentDepth == 0) {
          // Group ended
          result.add(maxDepth)
          groupStarted = false
        }
      }
    }
  }

  return result.toIntArray()
}
