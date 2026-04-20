package problems

/**
 * 2078. Two Furthest Houses With Different Colors
 *
 * There are n houses arranged in a row. Each house has a color represented by colors[i].
 * You want to select two houses with different colors, and you want to maximize the distance
 * between them (absolute difference between their indices).
 *
 * Strategy: The maximum distance always involves one endpoint (0 or n-1).
 * - Compare from right to left with first house color
 * - Compare from left to right with last house color
 * - Return the maximum of both distances
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
fun maxDistanceBetweenHouses(colors: IntArray): Int {
    val totalHouses = colors.size
    var maximumDistance = 0

    // Compare with first house - scan from right
    for (currentIndex in totalHouses - 1 downTo 0) {
        if (colors[currentIndex] != colors[0]) {
            maximumDistance = currentIndex
            break
        }
    }

    // Compare with last house - scan from left
    for (currentIndex in 0 until totalHouses) {
        if (colors[currentIndex] != colors[totalHouses - 1]) {
            val distanceFromEnd = (totalHouses - 1) - currentIndex
            maximumDistance = maxOf(maximumDistance, distanceFromEnd)
            break
        }
    }

    return maximumDistance
}
