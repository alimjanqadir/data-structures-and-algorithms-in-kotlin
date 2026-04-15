package problems

/**
 * 2515. Shortest Distance to Target String in a Circular Array
 *
 * Given a 0-indexed circular array words and a string target,
 * return the shortest distance from startIndex to the index where target appears.
 * If target does not exist in words, return -1.
 *
 * Time Complexity: O(n) where n is the length of words array
 * Space Complexity: O(1)
 */
fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
    val arrayLength = words.size
    var minimumDistance = Int.MAX_VALUE

    for (currentIndex in words.indices) {
        if (words[currentIndex] == target) {
            val moveRightSteps = (currentIndex - startIndex + arrayLength) % arrayLength
            val moveLeftSteps = (startIndex - currentIndex + arrayLength) % arrayLength

            val bestForThisIndex = minOf(moveRightSteps, moveLeftSteps)
            minimumDistance = minOf(minimumDistance, bestForThisIndex)
        }
    }

    return if (minimumDistance == Int.MAX_VALUE) -1 else minimumDistance
}
