package problems

/**
 * 2942. Find Words Containing Character
 * https://leetcode.com/problems/find-words-containing-character/description/
 */
fun findWordsContaining(words: Array<String>, x: Char): List<Int> =
    words.withIndex()
        .filter { x in it.value }
        .map { it.index }
