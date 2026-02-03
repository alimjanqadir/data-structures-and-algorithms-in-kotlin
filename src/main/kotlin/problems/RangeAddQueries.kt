package problems

/**
 * Increments submatrices in an n x n matrix based on the given range queries.
 * Each query [r1, c1, r2, c2] increments all cells in the submatrix from (r1, c1) to (r2, c2) by 1.
 * 
 * @param n The size of the n x n matrix.
 * @param queries Array of range queries where each query is represented as [r1, c1, r2, c2].
 * @return The resulting matrix after applying all queries.
 */
fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
  val diff = Array(n) { IntArray(n) }
  for (query in queries) {
    val r1 = query[0]
    val c1 = query[1]
    val r2 = query[2]
    val c2 = query[3]
    diff[r1][c1]++
    if (c2 + 1 < n) diff[r1][c2 + 1]--
    if (r2 + 1 < n) diff[r2 + 1][c1]--
    if (r2 + 1 < n && c2 + 1 < n) diff[r2 + 1][c2 + 1]++
  }
    
  val mat = Array(n) { IntArray(n) }
  for (i in 0 until n) {
    for (j in 0 until n) {
      when {
        i == 0 && j == 0 -> mat[0][0] = diff[0][0]
        i == 0 -> mat[0][j] = mat[0][j - 1] + diff[0][j]
        j == 0 -> mat[i][0] = mat[i - 1][0] + diff[i][0]
        else -> mat[i][j] = mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1] + diff[i][j]
      }
    }
  }
  return mat
}
