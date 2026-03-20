package problems

/**
 * 3643. Flip Square Submatrix Vertically
 *
 * You are given a 2D integer matrix grid with m rows and n columns.
 * You are also given integers x, y, and k.
 *
 * Flip the k × k submatrix whose top-left corner is at (x, y).
 * Flip means reverse the rows of the submatrix vertically.
 *
 * Time Complexity: O(k²)
 * Space Complexity: O(1) - in-place
 */
fun reverseSubmatrix(
    grid: Array<IntArray>,
    x: Int,
    y: Int,
    k: Int
): Array<IntArray> {
    for (offset in 0 until k / 2) {
        val topRow = x + offset
        val bottomRow = x + k - 1 - offset

        for (column in y until y + k) {
            val temp = grid[topRow][column]
            grid[topRow][column] = grid[bottomRow][column]
            grid[bottomRow][column] = temp
        }
    }

    return grid
}
