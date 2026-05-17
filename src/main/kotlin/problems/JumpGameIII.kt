package problems

fun canReach(arr: IntArray, start: Int): Boolean {
  val visited = BooleanArray(arr.size)
  val queue = ArrayDeque<Int>()
  queue.addLast(start)
  visited[start] = true

  while (queue.isNotEmpty()) {
    val currentIndex = queue.removeFirst()

    if (arr[currentIndex] == 0) {
      return true
    }

    val forwardIndex = currentIndex + arr[currentIndex]
    if (forwardIndex in arr.indices && !visited[forwardIndex]) {
      visited[forwardIndex] = true
      queue.addLast(forwardIndex)
    }

    val backwardIndex = currentIndex - arr[currentIndex]
    if (backwardIndex in arr.indices && !visited[backwardIndex]) {
      visited[backwardIndex] = true
      queue.addLast(backwardIndex)
    }
  }

  return false
}
