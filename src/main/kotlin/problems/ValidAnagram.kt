package problems

fun isAnagramBruteForce(s: String, t: String): Boolean {
  // If lengths are different, they can't be anagrams
  if (s.length != t.length) return false
  // Sort both strings and compare
  return s.toCharArray().sorted() == t.toCharArray().sorted()
}

private fun isAnagram(s: String, t: String): Boolean {
  // If lengths are different, they can't be anagrams
  if (s.length != t.length) return false
  // Create an array to store character counts (26 for lowercase English letters)
  val counts = IntArray(26)
  // Count characters in s (increment) and t (decrement)
  for (i in s.indices) {
    counts[s[i] - 'a']++
    counts[t[i] - 'a']--
  }
  // Check if all counts are zero
  return counts.all { it == 0 }
}

fun isAnagramFunctional(s: String, t: String): Boolean {
  // If lengths are different, they can't be anagrams
  if (s.length != t.length) return false
  // Function to count characters in a string
  fun countChars(str: String): Map<Char, Int> =
    str.groupingBy { it }.eachCount()
  // Compare character counts
  return countChars(s) == countChars(t)
}

fun main() {
  assert(isAnagram("anagram", "nagaram"))
  assert(!isAnagram("rat", "car"))
  assert(isAnagram("", ""))
  assert(isAnagram("a", "a"))
  assert(isAnagram("aab", "aba"))
  assert(!isAnagram("aab", "abc"))
  assert(!isAnagram("hello", "world"))
  println("All tests passed!")
}