package problems

/**
 * 2839. Check if Strings Can be Made Equal With Operations I
 *
 * You are given two strings s1 and s2, both of length 4, consisting of lowercase English letters.
 *
 * You can apply the following operation on any of the two strings any number of times:
 * - Choose any two indices i and j such that j - i = 2, then swap the two characters at those indices in the string.
 *
 * Return true if you can make the strings s1 and s2 equal, and false otherwise.
 *
 * @param s1 First string of length 4
 * @param s2 Second string of length 4
 * @return true if s1 can be made equal to s2, false otherwise
 */
fun canBeEqual(s1: String, s2: String): Boolean {
    val groupA1 = listOf(s1[0], s1[2]).sorted()
    val groupA2 = listOf(s2[0], s2[2]).sorted()

    val groupB1 = listOf(s1[1], s1[3]).sorted()
    val groupB2 = listOf(s2[1], s2[3]).sorted()

    return groupA1 == groupA2 && groupB1 == groupB2
}
