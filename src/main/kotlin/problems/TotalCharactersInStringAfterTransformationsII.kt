fun totalCharactersInStringAfterTransformationsII(s: String, t: Int, nums: List<Int>): Int {
  val MOD = 1000000007L
  // Step 1: Count initial frequencies
  val freq = LongArray(26)
  for (c in s) {
    freq[c - 'a']++
  }
  // Step 2: Build transformation matrix M
  val M = Array(26) { LongArray(26) }
  for (j in 0..25) {
    for (l in 1..nums[j]) {
      val m = (j + l) % 26
      M[m][j] = 1L
    }
  }
  // Step 3: Matrix multiplication function
  fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
    val c = Array(26) { LongArray(26) }
    for (i in 0..25) {
      for (j in 0..25) {
        var sum = 0L
        for (k in 0..25) {
          sum = (sum + a[i][k] * b[k][j]) % MOD
        }
        c[i][j] = sum
      }
    }
    return c
  }
  // Step 4: Matrix exponentiation function
  fun pow(mat: Array<LongArray>, t: Int): Array<LongArray> {
    var result = Array(26) { i -> LongArray(26) { j -> if (i == j) 1L else 0L } } // Identity matrix
    var current = mat.map { it.clone() }.toTypedArray() // Clone to avoid modifying original
    var t = t
    while (t > 0) {
      if (t % 2 == 1) {
        result = multiply(result, current)
      }
      current = multiply(current, current)
      t /= 2
    }
    return result
  }
  // Step 5: Compute M^t
  val M_t = pow(M, t)
  // Step 6: Compute final frequencies C_t = M^t * C_0
  val V = LongArray(26) { i ->
    var sum = 0L
    for (j in 0..25) {
      sum = (sum + M_t[i][j] * freq[j]) % MOD
    }
    sum
  }
  // Step 7: Compute total length modulo 10^9 + 7
  val total = V.sum() % MOD
  return total.toInt()
}
