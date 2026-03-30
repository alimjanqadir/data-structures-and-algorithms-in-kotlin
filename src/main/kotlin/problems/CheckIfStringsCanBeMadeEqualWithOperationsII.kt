package problems

/**
 * 2840. Check if Strings Can be Made Equal With Operations II
 *
 * You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.
 *
 * You can apply the following operation on any of the two strings any number of times:
 * - Choose any two indices i and j such that i < j and the difference j - i is even, then swap
 *   the two characters at those indices in the string.
 *
 * Return true if you can make the strings s1 and s2 equal, and false otherwise.
 *
 * @param firstWord First string
 * @param secondWord Second string
 * @return true if the strings can be made equal, false otherwise
 */
fun checkStrings(firstWord: String, secondWord: String): Boolean {
    val evenFrequencyFirst = IntArray(26)
    val oddFrequencyFirst = IntArray(26)
    val evenFrequencySecond = IntArray(26)
    val oddFrequencySecond = IntArray(26)

    for (index in firstWord.indices) {
        val charIndexFirst = firstWord[index] - 'a'
        val charIndexSecond = secondWord[index] - 'a'

        if (index % 2 == 0) {
            evenFrequencyFirst[charIndexFirst] += 1
            evenFrequencySecond[charIndexSecond] += 1
        } else {
            oddFrequencyFirst[charIndexFirst] += 1
            oddFrequencySecond[charIndexSecond] += 1
        }
    }

    return evenFrequencyFirst.contentEquals(evenFrequencySecond) &&
           oddFrequencyFirst.contentEquals(oddFrequencySecond)
}
