package problems

fun minJumps(arr: IntArray): Int {
  val lastIndex = arr.lastIndex
  if (lastIndex == 0) return 0

  val valueToIndices = HashMap<Int, MutableList<Int>>()
  for (index in arr.indices) {
    valueToIndices.getOrPut(arr[index]) { mutableListOf() }.add(index)
  }

  val visited = BooleanArray(arr.size)
  val queue = ArrayDeque<Int>()
  queue.addLast(0)
  visited[0] = true

  var steps = 0

  while (queue.isNotEmpty()) {
    repeat(queue.size) {
      val currentIndex = queue.removeFirst()
      if (currentIndex == lastIndex) return steps

      val currentValue = arr[currentIndex]
      val sameValueIndices = valueToIndices[currentValue]
      if (sameValueIndices != null) {
        for (nextIndex in sameValueIndices) {
          if (!visited[nextIndex]) {
            visited[nextIndex] = true
            queue.addLast(nextIndex)
          }
        }
        valueToIndices.remove(currentValue)
      }

      val leftIndex = currentIndex - 1
      if (leftIndex >= 0 && !visited[leftIndex]) {
        visited[leftIndex] = true
        queue.addLast(leftIndex)
      }

      val rightIndex = currentIndex + 1
      if (rightIndex <= lastIndex && !visited[rightIndex]) {
        visited[rightIndex] = true
        queue.addLast(rightIndex)
      }
    }
    steps++
  }

  return -1
}
