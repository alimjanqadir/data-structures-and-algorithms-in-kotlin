package problems

fun clearStars(input: String): String {
  val length = input.length

  // true  → character still present, false → already deleted
  val isKept = BooleanArray(length)

  // One stack per letter, stores indices that are still alive.
  val positionsByLetter = Array(26) { ArrayDeque<Int>() }

  for (position in input.indices) {
    val currentChar = input[position]

    if (currentChar == '*') {
      // Locate the smallest letter that still has a survivor.
      for (letterIndex in 0 until 26) {
        if (positionsByLetter[letterIndex].isNotEmpty()) {
          val deleteIndex = positionsByLetter[letterIndex].removeLast()
          isKept[deleteIndex] = false    // remove that letter
          break                          // star is implicitly discarded
        }
      }
    } else {
      val bucketIndex = currentChar - 'a'
      positionsByLetter[bucketIndex].addLast(position)
      isKept[position] = true               // mark as kept for now
    }
  }

  // Build the resulting string in original order.
  val resultBuilder = StringBuilder()
  for (position in input.indices) {
    if (isKept[position]) resultBuilder.append(input[position])
  }

  return resultBuilder.toString()
}
