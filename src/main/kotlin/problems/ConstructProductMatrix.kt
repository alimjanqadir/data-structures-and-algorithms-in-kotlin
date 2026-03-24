package problems

fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
  val rows = grid.size
  val cols = grid[0].size
  val mod = 12345
  val total = rows * cols

  val flattened = IntArray(total)
  var zeroCount = 0

  // Step 1: flatten + count zeros (mod 12345)
  for (index in 0 until total) {
    val value = grid[index / cols][index % cols] % mod
    flattened[index] = value
    if (value == 0) {
      zeroCount++
    }
  }

  val result = IntArray(total)

  // Case 1: more than one zero
  if (zeroCount > 1) {
    return Array(rows) { IntArray(cols) { 0 } }
  }

  // Case 2: exactly one zero
  if (zeroCount == 1) {
    var product = 1
    for (value in flattened) {
      if (value != 0) {
        product = (product * value) % mod
      }
    }

    for (index in 0 until total) {
      result[index] = if (flattened[index] == 0) product else 0
    }
  } else {
    // Case 3: no zeros → prefix-suffix
    var prefix = 1
    for (index in 0 until total) {
      result[index] = prefix
      prefix = (prefix * flattened[index]) % mod
    }

    var suffix = 1
    for (index in total - 1 downTo 0) {
      result[index] = (result[index] * suffix) % mod
      suffix = (suffix * flattened[index]) % mod
    }
  }

  // reshape to 2D
  val output = Array(rows) { IntArray(cols) }
  for (index in 0 until total) {
    output[index / cols][index % cols] = result[index]
  }

  return output
}
