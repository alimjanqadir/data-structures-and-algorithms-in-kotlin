package problems

/**
 * Finds the k-th character in the final string by reversing the operations.
 * This version avoids bit-shift overflow for large indices.
 *
 * @param k 1-based index of the character to find.
 * @param operations Array representing the sequence of operations to perform.
 * @return The character at position k in the final string.
 */
fun kthCharacter(k: Long, operations: IntArray): Char {
  // Tracks how many times type 1 operations increment the character.
  var totalCharacterShifts = 0
  // Work with 0-based indexing for simpler calculations.
  var targetIndex = k - 1

  // Iterate over the operations in reverse to "undo" them.
  for (operationPosition in operations.indices.reversed()) {
    // Avoid shifts >= 63 to prevent overflow: 1L shl 63 is safe, but shl 64 wraps to 1L.
    if (operationPosition >= 63) {
      continue
    }

    // Length of the string before this operation was applied.
    val lengthBeforeOperation = 1L shl operationPosition

    // If the target index lies in the second half after this operation,
    // it originates from the appended part.
    if (targetIndex >= lengthBeforeOperation) {
      // Map it back to its position in the first half.
      targetIndex -= lengthBeforeOperation

      // If this was a type 1 operation, we know the character was shifted once.
      if (operations[operationPosition] == 1) {
        totalCharacterShifts += 1
      }
    }
  }

  // After unwinding all operations, the starting character is 'a'.
  // Apply the total accumulated shifts, modulo 26 for alphabet wrapping.
  val resultingCharacter = 'a' + (totalCharacterShifts % 26)
  return resultingCharacter
}

