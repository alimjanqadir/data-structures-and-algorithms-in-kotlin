fun buildArray(permutation: IntArray): IntArray {
  val length = permutation.size
  // Pass 1 — write both old and new values into each slot.
  for (index in permutation.indices) {
    val originalValue = permutation[index]
    // We must read the second hop *before* we overwrite anything.
    val newValue = permutation[originalValue] % length
    permutation[index] = originalValue + newValue * length
  }
  // Pass 2 — strip away the original value; keep only the new one.
  for (index in permutation.indices) {
    permutation[index] = permutation[index] / length
  }
  return permutation      // now it *is* the answer
}
