package problems

/**
 * 2452. Words Within Two Edits of Dictionary
 *
 * You are given two string arrays, queries and dictionary. For each query string,
 * find whether there exists a string in the dictionary such that the edit distance
 * between them is at most 2. The edit distance is defined as the minimum number of
 * single-character edits needed to change one string into the other.
 *
 * Since all words have the same length, the edit distance equals the number of
 * positions with different characters.
 *
 * Time Complexity: O(Q * D * L) where Q = queries.size, D = dictionary.size, L = word length
 * Space Complexity: O(1) excluding the output list
 */
fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
    val matchingWords = mutableListOf<String>()

    for (queryWord in queries) {
        for (dictWord in dictionary) {
            var differenceCount = 0

            for (index in queryWord.indices) {
                if (queryWord[index] != dictWord[index]) {
                    differenceCount += 1
                    if (differenceCount > 2) {
                        break
                    }
                }
            }

            if (differenceCount <= 2) {
                matchingWords.add(queryWord)
                break
            }
        }
    }

    return matchingWords
}
