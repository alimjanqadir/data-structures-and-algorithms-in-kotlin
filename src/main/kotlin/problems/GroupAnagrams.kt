package problems

fun groupAnagramsBruteForce(strings: Array<String>): List<List<String>> {
  val result = mutableListOf<MutableList<String>>()

  for (str in strings) {
    var found = false
    for (group in result) {
      if (isAnagram(str, group[0])) {
        group.add(str)
        found = true
        break
      }
    }
    if (!found) {
      result.add(mutableListOf(str))
    }
  }

  return result
}

private fun isAnagram(stringA: String, stringB: String): Boolean {
  if (stringA.length != stringB.length) return false
  val count = IntArray(26)
  for (i in stringA.indices) {
    count[stringA[i] - 'a']++
    count[stringB[i] - 'a']--
  }
  return count.all { it == 0 }
}


fun groupAnagrams(input: Array<String>): List<List<String>> {
  // Use a mutable map to group anagrams
  val groups = mutableMapOf<String, MutableList<String>>()
  for (str in input) {
    // Generate a key based on character counts
    val key = generateKey(str)
    // Add the string to its anagram group
    groups.getOrPut(key) { mutableListOf() }.add(str)
  }
  // Return the values of the map as the result
  return groups.values.toList()
}

private fun generateKey(string: String): String {
  // Count the occurrences of each character
  val count = IntArray(26)
  for (char in string) {
    count[char - 'a']++
  }

  // Build a string key from the character counts
  return buildString {
    for (i in count.indices) {
      if (count[i] > 0) {
        append('#')
        append((i + 'a'.code).toChar())
        append(count[i])
      }
    }
  }
}

fun groupAnagramsFunctional(input: Array<String>): List<List<String>> =
  input.groupBy(::generateKeyFunctional)
    .values
    .toList()

private fun generateKeyFunctional(input: String): String =
  input.groupingBy { it }
    .eachCount()
    .entries
    .sortedBy { it.key }
    .joinToString("") { "${it.key}${it.value}" }

fun main() {
  // Test 1: Normal case
  val result1 = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
  assert(result1.size == 3) { "Test 1 failed: Expected 3 groups, but got ${result1.size}" }
  assert(result1.any { it.containsAll(listOf("eat", "tea", "ate")) }) { "Test 1 failed: Missing group [eat, tea, ate]" }
  assert(result1.any { it.containsAll(listOf("tan", "nat")) }) { "Test 1 failed: Missing group [tan, nat]" }
  assert(result1.any { it == listOf("bat") }) { "Test 1 failed: Missing group [bat]" }

  // Test 2: Empty string
  val result2 = groupAnagrams(arrayOf(""))
  assert(result2 == listOf(listOf(""))) { "Test 2 failed: Expected [['']], but got $result2" }

  // Test 3: Single character
  val result3 = groupAnagrams(arrayOf("a"))
  assert(result3 == listOf(listOf("a"))) { "Test 3 failed: Expected [['a']], but got $result3" }

  // Test 4: All unique strings
  val result4 = groupAnagrams(arrayOf("abc", "def", "ghi"))
  assert(result4.size == 3) { "Test 4 failed: Expected 3 groups, but got ${result4.size}" }
  assert(result4.all { it.size == 1 }) { "Test 4 failed: Each group should contain exactly one string" }

  // Test 5: All anagrams
  val result5 = groupAnagrams(arrayOf("abc", "bca", "cab"))
  assert(result5.size == 1) { "Test 5 failed: Expected 1 group, but got ${result5.size}" }
  assert(result5[0].containsAll(listOf("abc", "bca", "cab"))) { "Test 5 failed: Group should contain all three strings" }

  println("All tests passed successfully!")
}