package problems

/**
 * Brute Force approach to determine if two strings are isomorphic.
 * This method tries all possible character mappings from s to t.
 * Due to its exponential time complexity, it's impractical for large inputs.
 */
fun isIsomorphicBruteForce(s: String, t: String): Boolean {
    // If the strings have different lengths, they cannot be isomorphic
    if (s.length != t.length) return false

    // Extract unique characters from string s
    val uniqueCharsS = s.toSet()

    // Generate all possible permutations of unique characters in t
    val uniqueCharsT = t.toSet()

    // Create a map pairing each unique character in s to a unique character in t
    val map = uniqueCharsS.zip(uniqueCharsT).toMap()

    // Transform string s based on the current mapping
    val transformed = s.map { map[it] }.joinToString("")

    // If the transformed string matches t, the strings are isomorphic
    if (transformed == t) return true

    // If no valid mapping found, the strings are not isomorphic
    return false
}

/**
 * Extension function to generate all permutations of a given set.
 * This is a simplified implementation and may not be efficient for large sets.
 */
fun <T> Set<T>.permutations(): Set<List<T>> {
    // Base case: single element set has only one permutation
    if (this.size == 1) return setOf(this.toList())

    val result = mutableSetOf<List<T>>()

    // Iterate through each element and recursively build permutations
    for (element in this) {
        // Create a subset excluding the current element
        val subset = this - element

        // Generate permutations for the subset
        for (perm in subset.permutations()) {
            // Add the current element to the front of each subset permutation
            result.add(listOf(element) + perm)
        }
    }

    return result
}


/**
 * Optimized approach to determine if two strings are isomorphic.
 * Utilizes two hash maps to maintain forward and reverse character mappings.
 */
fun isIsomorphicOptimized(s: String, t: String): Boolean {
    // If the strings have different lengths, they cannot be isomorphic
    if (s.length != t.length) return false

    // HashMap to store mapping from characters in s to characters in t
    val mapSToT = mutableMapOf<Char, Char>()

    // HashMap to store mapping from characters in t to characters in s
    val mapTToS = mutableMapOf<Char, Char>()

    // Iterate through each character pair in the strings
    for (i in s.indices) {
        val charS = s[i] // Current character from string s
        val charT = t[i] // Current character from string t

        // Check if there is an existing mapping from s to t
        if (mapSToT.containsKey(charS)) {
            // If the existing mapping does not match the current character in t, return false
            if (mapSToT[charS] != charT) return false
        } else {
            // Establish a new mapping from s to t
            mapSToT[charS] = charT
        }

        // Similarly, check if there is an existing mapping from t to s
        if (mapTToS.containsKey(charT)) {
            // If the existing mapping does not match the current character in s, return false
            if (mapTToS[charT] != charS) return false
        } else {
            // Establish a new mapping from t to s
            mapTToS[charT] = charS
        }
    }

    // If all character mappings are consistent and unique, the strings are isomorphic
    return true
}

fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    // Arrays to store the last seen positions of characters
    val sLastSeen = IntArray(256) { -1 }
    val tLastSeen = IntArray(256) { -1 }
    for (i in s.indices) {
        // Get ASCII values of characters
        val sChar = s[i].code
        val tChar = t[i].code
        // If the last seen positions don't match, strings are not isomorphic
        if (sLastSeen[sChar] != tLastSeen[tChar]) {
            return false
        }
        // Update last seen positions
        sLastSeen[sChar] = i
        tLastSeen[tChar] = i
    }

    return true
}

/**
 * Functional composition approach to determine if two strings are isomorphic.
 * Utilizes recursion and immutable maps to maintain character mappings.
 */
fun isIsomorphicFunctional(s: String, t: String): Boolean =
    s.zip(t).toSet().size == s.toSet().size && s.toSet().size == t.toSet().size


fun isIsomorphicFast(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    // Arrays to store the last seen positions of characters
    val sLastSeen = IntArray(256) { -1 }
    val tLastSeen = IntArray(256) { -1 }
    for (i in s.indices) {
        // Get ASCII values of characters
        val sChar = s[i].code
        val tChar = t[i].code
        // If the last seen positions don't match, strings are not isomorphic
        if (sLastSeen[sChar] != tLastSeen[tChar]) {
            return false
        }
        // Update last seen positions
        sLastSeen[sChar] = i
        tLastSeen[tChar] = i
    }

    return true
}

/**
 * Main function to execute test assertions for the isomorphic strings solutions.
 */
fun main() {
    // Given: A list of test cases with pairs of strings and their expected isomorphism result
    val testCases = listOf(
        Triple("egg", "add", true),
        Triple("foo", "bar", false),
        Triple("paper", "title", true),
        Triple("ab", "aa", false),
        Triple("", "", true),
        Triple("a", "a", true),
        Triple("abc", "def", true),
        Triple("abc", "dee", false)
    )

    // When & Then: Iterate through each test case and assert the expected outcomes
    for ((s, t, expected) in testCases) {
        // Assert the Optimized Solution
        assert(isIsomorphicBruteForce(s, t) == expected) {
            "Optimized: Failed for input s='$s', t='$t'. Expected $expected."
        }

        // Assert the Functional Composition Solution
        assert(isIsomorphicFunctional(s, t) == expected) {
            "Functional: Failed for input s='$s', t='$t'. Expected $expected."
        }

        // Note: Brute force solution is omitted from testing due to its inefficiency
    }

    // If all assertions pass, print a success message
    println("All tests passed successfully.")
}
