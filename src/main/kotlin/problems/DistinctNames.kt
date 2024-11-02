package problems

fun distinctNames(ideas: Array<String>): Long {
  // Map to hold suffixes grouped by their first character
  val suffixGroups = Array(26) { mutableSetOf<String>() }

  // Populate the suffix groups
  for (idea in ideas) {
    val index = idea[0] - 'a' // Index corresponding to the first character
    suffixGroups[index].add(idea.substring(1)) // Store the suffix
  }

  var result = 0L

  // Compare every pair of different first characters
  for (i in 0 until 25) {
    for (j in i + 1 until 26) {
      // Sets of suffixes for first characters i and j
      val groupA = suffixGroups[i]
      val groupB = suffixGroups[j]

      // Count of common suffixes between the two groups
      val commonSuffixes = groupA.intersect(groupB).size

      // Number of unique suffixes in each group
      val uniqueA = groupA.size - commonSuffixes
      val uniqueB = groupB.size - commonSuffixes

      // Total valid combinations is twice the product of unique counts
      result += 2L * uniqueA * uniqueB
    }
  }

  return result
}

fun distinctNamesFunctional(ideas: Array<String>): Long {
  // Step 1: Group suffixes by their first character using immutable data structures
  val suffixGroups: List<Set<String>> = ('a'..'z').map { firstChar ->
    ideas.filter { it.startsWith(firstChar) }
      .map { it.substring(1) }
      .toSet()
  }

  // Step 2: Generate all unique pairs of starting letters
  val pairs = ('a'..'y').flatMap { firstChar ->
    ((firstChar + 1)..'z').map { secondChar ->
      Pair(firstChar, secondChar)
    }
  }

  // Step 3: Calculate total valid names using functional operations
  return pairs.fold(0L) { acc, pair ->
    val indexA = pair.first - 'a'
    val indexB = pair.second - 'a'
    val groupA = suffixGroups[indexA]
    val groupB = suffixGroups[indexB]

    val commonSuffixes = groupA.intersect(groupB).size
    val uniqueA = groupA.size - commonSuffixes
    val uniqueB = groupB.size - commonSuffixes

    acc + 2L * uniqueA * uniqueB
  }
}

fun main() {
  assert(distinctNames(arrayOf("coffee", "donuts", "time", "toffee")) == 6L)
  assert(distinctNames(arrayOf("lack", "back")) == 0L)
  assert(distinctNames(arrayOf("apple", "banana", "cherry", "date")) == 12L)
  assert(distinctNames(arrayOf("aa", "ab", "ac", "ad")) == 12L)
  assert(distinctNames(arrayOf("king", "ring", "wing", "sing")) == 12L)
  println("All test cases passed!")
}