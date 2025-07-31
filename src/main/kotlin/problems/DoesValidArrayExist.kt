package problems

fun doesValidArrayExist(derived: IntArray): Boolean {
  var totalXor = 0
  for (bit in derived) {
    totalXor = totalXor xor bit
  }
  return totalXor == 0
}
