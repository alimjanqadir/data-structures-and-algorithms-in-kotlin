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

