package problems

fun minimizedStringLength(s: String): Int {
  // Constraints: s.length >= 1, s contains only lowercase English letters.

  // Use a BooleanArray to track presence of characters 'a' through 'z'.
  // This avoids hashing overhead and is likely the fastest for a small, fixed alphabet.
  val seen = BooleanArray(26) // All initialized to false
  var uniqueCount = 0

  // Iterate through the string characters
  for (char in s) {
    // Calculate the 0-based index for the character ('a' -> 0, 'b' -> 1, ...)
    val index = char - 'a'

    // If this character hasn't been seen before...
    if (!seen[index]) {
      seen[index] = true // Mark it as seen
      uniqueCount++      // Increment the count of unique characters

      // Optimization: If we have found all 26 possible characters,
      // no need to check the rest of the string.
      if (uniqueCount == 26) {
        break
      }
    }
  }

  return uniqueCount
}

/**
 * Calculates the minimum length of the string after applying operations.
 *
 * The operations effectively allow removing all duplicate characters.
 * Therefore, the minimum length is simply the count of unique characters
 * present in the original string.
 *
 * @param s The input string containing lowercase English letters.
 * @return The minimum possible length of the string, which is the count of unique characters.
 */
fun minimizedStringLengthHashMap(s: String): Int {
  // Convert the String to a Set<Char>. Sets inherently store only unique elements.
  // The .toSet() extension function is a concise and idiomatic way to do this in Kotlin.
  val uniqueCharacters = s.toSet()

  // The size of the set gives the count of unique characters.
  return uniqueCharacters.size

  // Alternatively, in a single line:
  // return s.toSet().size
}

// Example Usage (outside LeetCode environment):
fun main() {
  println("Input: aaabc, Output: ${minimizedStringLength("aaabc")}")       // Output: 3
  println("Input: cbbd, Output: ${minimizedStringLength("cbbd")}")        // Output: 3
  println("Input: baadccab, Output: ${minimizedStringLength("baadccab")}") // Output: 4
  println("Input: hello, Output: ${minimizedStringLength("hello")}")       // Output: 4
  println("Input: zzzzz, Output: ${minimizedStringLength("zzzzz")}")       // Output: 1
  println("Input: abcdef, Output: ${minimizedStringLength("abcdef")}")     // Output: 6
}