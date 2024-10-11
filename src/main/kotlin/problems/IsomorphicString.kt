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
    val permutations = t.toSet().permutations()

    // Iterate through each possible mapping permutation
    for (mapping in permutations) {
        // Create a map pairing each unique character in s to a unique character in t
        val map = uniqueCharsS.zip(mapping).toMap()

        // Transform string s based on the current mapping
        val transformed = s.map { map[it] }.joinToString("")

        // If the transformed string matches t, the strings are isomorphic
        if (transformed == t) return true
    }

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

/**
 * Functional composition approach to determine if two strings are isomorphic.
 * Utilizes recursion and immutable maps to maintain character mappings.
 */
fun isIsomorphicFunctional(s: String, t: String): Boolean {
    /**
     * Recursive helper function to traverse the strings and validate mappings.
     *
     * @param index Current index in the strings being compared.
     * @param mapSToT Current mapping from characters in s to characters in t.
     * @param mapTToS Current mapping from characters in t to characters in s.
     * @return Boolean indicating if the strings are isomorphic up to the current index.
     */
    fun helper(
        index: Int,
        mapSToT: Map<Char, Char>,
        mapTToS: Map<Char, Char>
    ): Boolean {
        // Base case: If we've reached the end of the strings, return true
        if (index == s.length) return true

        val charS = s[index] // Current character from string s
        val charT = t[index] // Current character from string t

        // Retrieve the mapped characters, if any
        val mappedCharT = mapSToT[charS]
        val mappedCharS = mapTToS[charT]

        return when {
            // If there is no existing mapping for both characters, establish new mappings
            mappedCharT == null && mappedCharS == null -> {
                // Recursively call helper with updated mappings
                helper(
                    index + 1,
                    mapSToT + (charS to charT),
                    mapTToS + (charT to charS)
                )
            }
            // If existing mappings are consistent with current characters, continue recursion
            mappedCharT == charT && mappedCharS == charS -> {
                helper(index + 1, mapSToT, mapTToS)
            }
            // If mappings are inconsistent, the strings are not isomorphic
            else -> false
        }
    }

    // If the strings have different lengths, they cannot be isomorphic
    if (s.length != t.length) return false

    // Initiate recursion with initial index and empty mappings
    return helper(0, emptyMap(), emptyMap())
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
        assert(isIsomorphicOptimized(s, t) == expected) {
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
