package problems

/**
 * Validates if a string of brackets is properly matched and nested.
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) in worst case where all brackets are opening brackets
 */
fun isValid(s: String): Boolean {
  // Early return for odd-length strings (can't be valid)
  if (s.length % 2 != 0) return false

  // Use ArrayDeque as a stack for better performance than Stack class
  val stack = ArrayDeque<Char>()

  // Map closing brackets to their corresponding opening brackets
  val bracketPairs = mapOf(
    ')' to '(',
    ']' to '[',
    '}' to '{'
  )

  for (char in s) {
    when (char) {
      // For opening brackets, push to stack
      '(', '[', '{' -> stack.addLast(char)
      // For closing brackets
      else -> {
        // If stack is empty or top doesn't match current closing bracket
        if (stack.isEmpty() || stack.removeLast() != bracketPairs[char]) {
          return false
        }
      }
    }
  }

  // Valid only if all brackets are matched (stack is empty)
  return stack.isEmpty()
}

/**
 * Alternative functional solution using fold
 * Demonstrates Kotlin's functional programming capabilities
 */
fun isValidFunctional(s: String): Boolean {
  return s.length % 2 == 0 && s.fold(ArrayDeque<Char>()) { stack, char ->
    when (char) {
      '(', '[', '{' -> stack.apply { addLast(char) }
      else -> stack.takeIf {
        it.isNotEmpty() && it.last() == when (char) {
          ')' -> '('
          ']' -> '['
          '}' -> '{'
          else -> null
        }
      }?.apply { removeLast() } ?: return false
    }
  }.isEmpty()
}

fun main() {
  // Test cases
  val testCases = listOf(
    "()" to true,
    "()[]{}" to true,
    "(]" to false,
    "([)]" to false,
    "{[]}" to true,
    "]" to false,
    "(((" to false,
    "" to true
  )

  // Run tests and print results
  testCases.forEachIndexed { index, (input, expected) ->
    val actual = isValid(input)
    val result = if (actual == expected) "PASS" else "FAIL"
    println("Test $index: '$input' → Expected: $expected, Got: $actual - $result")
  }

  // Performance test with max length input
  val largeInput = "(".repeat(5000) + ")".repeat(5000)
  val start = System.nanoTime()
  isValid(largeInput)
  val duration = (System.nanoTime() - start) / 1_000_000.0
  println("\nPerformance test (10000 brackets): $duration ms")
}