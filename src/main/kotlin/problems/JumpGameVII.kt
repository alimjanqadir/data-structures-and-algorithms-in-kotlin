fun canReachJumpGameVII(s: String, minJump: Int, maxJump: Int): Boolean {
  if (s.last() != '0') return false

  val stringLength = s.length
  val queue = ArrayDeque<Int>()
  queue.addLast(0)

  var farthestProcessedIndex = 0

  while (queue.isNotEmpty()) {
    val currentIndex = queue.removeFirst()

    if (currentIndex == stringLength - 1) {
      return true
    }

    val startIndex = maxOf(currentIndex + minJump, farthestProcessedIndex + 1)
    val endIndex = minOf(currentIndex + maxJump, stringLength - 1)

    for (nextIndex in startIndex..endIndex) {
      if (s[nextIndex] == '0') {
        queue.addLast(nextIndex)
      }
    }

    farthestProcessedIndex = maxOf(farthestProcessedIndex, endIndex)
  }

  return false
}
