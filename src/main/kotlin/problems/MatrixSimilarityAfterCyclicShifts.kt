package problems

/**
 * 2946. Matrix Similarity After Cyclic Shifts
 *
 * You are given an m x n integer matrix mat and an integer k.
 * The matrix rows are 0-indexed.
 *
 * The following process happens k times:
 * - Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.
 * - Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.
 *
 * Return true if the final modified matrix after k steps is identical to the original matrix,
 * and false otherwise.
 *
 * Time Complexity: O(m * n) where m is number of rows and n is number of columns
 * Space Complexity: O(1)
 */
fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
  val m = mat.size
  val n = mat[0].size

  // Effective shifts needed
  val shift = k % n

  // If k is a multiple of n, no change happens anyway
  if (shift == 0) return true

  for (i in 0 until m) {
    for (j in 0 until n) {
      // Check if the element at j matches the element k positions away
      // This works for both left and right shifts because similarity
      // implies periodicity within the row.
      if (mat[i][j] != mat[i][(j + shift) % n]) {
        return false
      }
    }
  }

  return true
}
