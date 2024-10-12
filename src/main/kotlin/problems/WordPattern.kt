package problems

fun wordPatternBruteForce(pattern: String, s: String): Boolean {
    // Split the string `s` into a list of words based on spaces.
    val words = s.split(" ")

    // If the lengths of pattern and words do not match, return false.
    if (pattern.length != words.size) return false

    // Maps to hold the mappings between characters and words
    val charToWord = mutableMapOf<Char, String>() // Maps characters in pattern to words
    val wordToChar = mutableMapOf<String, Char>() // Maps words to characters in pattern

    // Iterate over each character in the pattern
    for (i in pattern.indices) {
        val c = pattern[i] // Current character in the pattern
        val word = words[i] // Corresponding word in the string

        // Check if the character already has a mapped word
        if (charToWord.containsKey(c)) {
            // If the mapped word is not the same as the current word, return false
            if (charToWord[c] != word) return false
        } else {
            // Map the character to the current word
            charToWord[c] = word
        }

        // Check if the word already has a mapped character
        if (wordToChar.containsKey(word)) {
            // If the mapped character is not the same as the current character, return false
            if (wordToChar[word] != c) return false
        } else {
            // Map the word to the current character
            wordToChar[word] = c
        }
    }
    // If all mappings are consistent, return true
    return true
}

fun wordPatternOptimized(pattern: String, s: String): Boolean {
    // Split the string `s` into a list of words based on spaces.
    val words = s.split(" ")

    // If the lengths of pattern and words do not match, return false.
    if (pattern.length != words.size) return false

    // Create a HashMap to store last seen indices of both characters and words
    val mapping = HashMap<Any, Int>()

    // Iterate over each character in the pattern
    for (i in pattern.indices) {
        val c = pattern[i] // Current character in the pattern
        val word = words[i] // Corresponding word in the string

        // Put the current index of character and word into the mapping
        val cIndex = mapping.put(c, i) // Get last index of character
        val wIndex = mapping.put(word, i) // Get last index of word

        // If the last seen indices do not match, return false
        if (cIndex != wIndex) return false
    }
    // If all mappings are consistent, return true
    return true
}

fun wordPatternFunctional(pattern: String, s: String): Boolean {
    // Split the string `s` into a list of words based on spaces.
    val words = s.split(" ")

    // If the lengths of pattern and words do not match, return false.
    if (pattern.length != words.size) return false

    // Create pairs of characters and words using zip
    val charWordPairs = pattern.zip(words.toString())

    // Create a map from characters to words
    val charToWord = charWordPairs.toMap() // Maps character in pattern to the corresponding word
    // Create a map from words to characters
    val wordToChar = charWordPairs.map { it.second to it.first }.toMap() // Maps word to corresponding character

    // Check that for each pair, the mappings are consistent
    return charWordPairs.all { (c, w) ->
        charToWord[c] == w && wordToChar[w] == c // Check bijection property
    }
}

fun main() {
    // Test cases for Brute Force Solution
    assert(wordPatternBruteForce("abba", "dog cat cat dog")) // Should return true
    assert(!wordPatternBruteForce("abba", "dog cat cat fish")) // Should return false
    assert(!wordPatternBruteForce("aaaa", "dog cat cat dog")) // Should return false
    assert(!wordPatternBruteForce("abba", "dog dog dog dog")) // Should return false

    // Test cases for Optimized Solution
    assert(wordPatternOptimized("abba", "dog cat cat dog")) // Should return true
    assert(!wordPatternOptimized("abba", "dog cat cat fish")) // Should return false
    assert(!wordPatternOptimized("aaaa", "dog cat cat dog")) // Should return false
    assert(!wordPatternOptimized("abba", "dog dog dog dog")) // Should return false

    // Test cases for Functional Composition Solution
    assert(wordPatternFunctional("abba", "dog cat cat dog")) // Should return true
    assert(!wordPatternFunctional("abba", "dog cat cat fish")) // Should return false
    assert(!wordPatternFunctional("aaaa", "dog cat cat dog")) // Should return false
    assert(!wordPatternFunctional("abba", "dog dog dog dog")) // Should return false

    println("All tests passed!") // Confirmation message
}