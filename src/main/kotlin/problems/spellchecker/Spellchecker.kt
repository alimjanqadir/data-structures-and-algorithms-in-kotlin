package problems.spellchecker

class Solution {
  fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
    val exactSet = HashSet<String>()
    val caseMap = HashMap<String, String>()           // lowercase -> first original
    val vowelMap = HashMap<String, String>()          // devoweled(lowercase) -> first original

    fun isVowel(ch: Char): Boolean {
      return when (ch) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
      }
    }

    fun devowel(lowercaseWord: String): String {
      val builder = StringBuilder()
      for (character in lowercaseWord) {
        builder.append(if (isVowel(character)) '*' else character)
      }
      return builder.toString()
    }

    // Build indexes honoring "first match" precedence
    for (originalWord in wordlist) {
      exactSet.add(originalWord)

      val lower = originalWord.lowercase()
      if (!caseMap.containsKey(lower)) {
        caseMap[lower] = originalWord
      }

      val devoweled = devowel(lower)
      if (!vowelMap.containsKey(devoweled)) {
        vowelMap[devoweled] = originalWord
      }
    }

    // Answer queries
    val results = Array(queries.size) { "" }
    for (queryIndex in queries.indices) {
      val query = queries[queryIndex]

      // 1) Exact match
      if (exactSet.contains(query)) {
        results[queryIndex] = query
        continue
      }

      // 2) Case-insensitive match
      val lower = query.lowercase()
      val caseCandidate = caseMap[lower]
      if (caseCandidate != null) {
        results[queryIndex] = caseCandidate
        continue
      }

      // 3) Vowel-error match
      val devoweled = devowel(lower)
      val vowelCandidate = vowelMap[devoweled]
      if (vowelCandidate != null) {
        results[queryIndex] = vowelCandidate
        continue
      }

      // 4) No match -> ""
      results[queryIndex] = ""
    }

    return results
  }
}

