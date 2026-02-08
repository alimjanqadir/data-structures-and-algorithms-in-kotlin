package problems.minimumteachings

class Solution {
  fun minimumTeachings(
    n: Int,
    languages: Array<IntArray>,
    friendships: Array<IntArray>
  ): Int {
    val userCount = languages.size

    // knows[user][language] = true if user (1-based) knows language (1..n)
    val knows = Array(userCount + 1) { BooleanArray(n + 1) }
    for (user in 1..userCount) {
      for (languageId in languages[user - 1]) {
        knows[user][languageId] = true
      }
    }

    // Collect users involved in friendships that currently cannot communicate
    val usersNeedingTeaching = HashSet<Int>()

    fun canCommunicate(userA: Int, userB: Int): Boolean {
      // Iterate over the smaller language list for speed
      val smaller =
        if (languages[userA - 1].size <= languages[userB - 1].size) userA else userB
      val other = if (smaller == userA) userB else userA
      for (languageId in languages[smaller - 1]) {
        if (knows[other][languageId]) return true
      }
      return false
    }

    for (pair in friendships) {
      val userA = pair[0]
      val userB = pair[1]
      if (!canCommunicate(userA, userB)) {
        usersNeedingTeaching.add(userA)
        usersNeedingTeaching.add(userB)
      }
    }

    if (usersNeedingTeaching.isEmpty()) return 0

    // For each language, count how many users in usersNeedingTeaching already know it
    val countByLanguage = IntArray(n + 1)
    for (user in usersNeedingTeaching) {
      for (languageId in languages[user - 1]) {
        countByLanguage[languageId] = countByLanguage[languageId] + 1
      }
    }

    var bestKnownCount = 0
    for (languageId in 1..n) {
      if (countByLanguage[languageId] > bestKnownCount) {
        bestKnownCount = countByLanguage[languageId]
      }
    }

    return usersNeedingTeaching.size - bestKnownCount
  }
}

