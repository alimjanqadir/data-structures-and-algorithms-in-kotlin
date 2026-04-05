package problems

/**
 * 657. Robot Return to Origin
 * LeetCode problem: Easy
 *
 * Determines if a robot returns to the origin after a series of moves.
 * The robot moves on a 2D plane starting from (0, 0).
 * 'U' = up, 'D' = down, 'R' = right, 'L' = left
 *
 * Time Complexity: O(n) where n is the length of the moves string
 * Space Complexity: O(1)
 *
 * @param moves String containing moves: 'U', 'D', 'R', 'L'
 * @return true if robot returns to origin, false otherwise
 */
fun judgeCircle(moves: String): Boolean {
  var horizontalPosition = 0
  var verticalPosition = 0

  for (move in moves) {
    when (move) {
      'U' -> verticalPosition += 1
      'D' -> verticalPosition -= 1
      'R' -> horizontalPosition += 1
      'L' -> horizontalPosition -= 1
    }
  }

  return horizontalPosition == 0 && verticalPosition == 0
}
