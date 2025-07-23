package problems

/**
 * Solution for LeetCode problem "Maximum Candies You Can Get from Boxes"
 * https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
 */
fun maxCandies(
  status: IntArray,
  candies: IntArray,
  keysInBox: Array<IntArray>,
  containedBoxes: Array<IntArray>,
  initialBoxes: IntArray
): Int {
  val ownedButClosed = mutableSetOf<Int>()
  val keyAvailable   = BooleanArray(status.size)
  val boxProcessed   = BooleanArray(status.size)

  val readyQueue: ArrayDeque<Int> = ArrayDeque()

  fun tryEnqueue(box: Int) {
    if (boxProcessed[box]) return
    if (status[box] == 1 || keyAvailable[box]) {
      readyQueue.add(box)
    } else {
      ownedButClosed.add(box)
    }
  }


  // Seed with initial supply
  for (box in initialBoxes) tryEnqueue(box)

  var totalCandies = 0

  while (readyQueue.isNotEmpty()) {
    val current = readyQueue.removeFirst()
    if (boxProcessed[current]) continue    // may reach again via key-edge
    boxProcessed[current] = true

    // 1. Collect candies
    totalCandies += candies[current]

    // 2. Process keys
    for (key in keysInBox[current]) {
      if (!keyAvailable[key]) {
        keyAvailable[key] = true
        if (key in ownedButClosed) {   // was waiting, now open
          ownedButClosed.remove(key)
          readyQueue.add(key)
        }
      }
    }


    // 3. Process contained boxes
    for (child in containedBoxes[current]) {
      tryEnqueue(child)
    }
  }


  return totalCandies
}

/**
 * Test cases for maxCandies function
 */
