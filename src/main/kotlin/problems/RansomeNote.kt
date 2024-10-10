@file:Suppress("SimplifyBooleanWithConstants")

package problems

fun canConstructBruteForce(ransomNote: String, magazine: String): Boolean {
    // Convert magazine to a mutable list to track used characters
    val magazineChars = magazine.toMutableList()

    // Iterate over each character in ransomNote
    for (char in ransomNote) {
        // Check if the character exists in magazineChars
        if (magazineChars.contains(char)) {
            // Remove the first occurrence of the character
            magazineChars.remove(char)
        } else {
            // Character not found, cannot construct ransomNote
            return false
        }
    }
    // All characters found, can construct ransomNote
    return true
}

fun canConstructOptimized(ransomNote: String, magazine: String): Boolean {
    // Array to hold the count of each character in magazine
    val charCounts = IntArray(26)

    // Count each character in magazine
    for (char in magazine) {
        charCounts[char - 'a']++
    }

    // Iterate over ransomNote and decrement counts
    for (char in ransomNote) {
        val index = char - 'a'
        charCounts[index]--
        if (charCounts[index] < 0) {
            // Not enough of this character in magazine
            return false
        }
    }
    // All characters are available
    return true
}

fun canConstructFunctional(ransomNote: String, magazine: String): Boolean {
    // Create frequency map for magazine using groupingBy and eachCount
    val magazineCounts = magazine.groupingBy { it }.eachCount()

    // Create frequency map for ransomNote
    val ransomNoteCounts = ransomNote.groupingBy { it }.eachCount()

    // Check if ransomNoteCounts can be satisfied by magazineCounts
    return ransomNoteCounts.all { (char, count) ->
        magazineCounts.getOrDefault(char, 0) >= count
    }
}

fun main() {
    // Brute Force Solution Tests
    assert(canConstructBruteForce("a", "b") == false)
    assert(canConstructBruteForce("aa", "ab") == false)
    assert(canConstructBruteForce("aa", "aab") == true)
    assert(canConstructBruteForce("", "") == true)
    assert(canConstructBruteForce("abc", "cba") == true)
    assert(canConstructBruteForce("abc", "def") == false)
    assert(canConstructBruteForce("aabbcc", "abcabc") == true)
    assert(canConstructBruteForce("aabbcc", "abccba"))
    assert(canConstructBruteForce("aabbccdd", "aabbcc") == false)
    println("Brute Force Solution Tests Passed")

    // Optimized Solution Tests
    assert(canConstructOptimized("a", "b") == false)
    assert(canConstructOptimized("aa", "ab") == false)
    assert(canConstructOptimized("aa", "aab") == true)
    assert(canConstructOptimized("", "") == true)
    assert(canConstructOptimized("abc", "cba") == true)
    assert(canConstructOptimized("abc", "def") == false)
    assert(canConstructOptimized("aabbcc", "abcabc") == true)
    assert(canConstructOptimized("aabbcc", "abccba") == true)
    assert(canConstructOptimized("aabbccdd", "aabbcc") == false)
    println("Optimized Solution Tests Passed")

    // Functional Composition Solution Tests
    assert(canConstructFunctional("a", "b") == false)
    assert(canConstructFunctional("aa", "ab") == false)
    assert(canConstructFunctional("aa", "aab") == true)
    assert(canConstructFunctional("", "") == true)
    assert(canConstructFunctional("abc", "cba") == true)
    assert(canConstructFunctional("abc", "def") == false)
    assert(canConstructFunctional("aabbcc", "abcabc") == true)
    assert(canConstructFunctional("aabbcc", "abccba") == true)
    assert(canConstructFunctional("aabbccdd", "aabbcc") == false)
    println("Functional Composition Solution Tests Passed")
}