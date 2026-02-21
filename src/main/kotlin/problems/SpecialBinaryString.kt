package problems

fun makeLargestSpecial(binaryString: String): String {
  val topLevelSpecialBlocks = mutableListOf<String>()

  var balance = 0
  var currentBlockStart = 0

  for (currentIndex in binaryString.indices) {
    balance += if (binaryString[currentIndex] == '1') 1 else -1

    if (balance == 0) {
      val innerContent =
        binaryString.substring(currentBlockStart + 1, currentIndex)

      val optimizedInnerContent =
        makeLargestSpecial(innerContent)

      val wrappedSpecialBlock =
        wrapAsSpecialBlock(optimizedInnerContent)

      topLevelSpecialBlocks.add(wrappedSpecialBlock)
      currentBlockStart = currentIndex + 1
    }
  }

  topLevelSpecialBlocks.sortDescending()

  return topLevelSpecialBlocks.joinToString("")
}

private fun wrapAsSpecialBlock(innerContent: String): String {
  return "1$innerContent" + "0"
}
