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
fun main() {
  // Test case 1
  val status1 = intArrayOf(1, 0, 1, 0)
  val candies1 = intArrayOf(7, 5, 4, 100)
  val keysInBox1 = arrayOf(intArrayOf(), intArrayOf(), intArrayOf(1), intArrayOf())
  val containedBoxes1 = arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(), intArrayOf())
  val initialBoxes1 = intArrayOf(0)
  println(maxCandies(status1, candies1, keysInBox1, containedBoxes1, initialBoxes1)) // Expected: 16
    
  // Test case 2
  val status2 = intArrayOf(1, 0, 0, 0, 0, 0)
  val candies2 = intArrayOf(1, 1, 1, 1, 1, 1)
  val keysInBox2 = arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(), intArrayOf(), intArrayOf(), intArrayOf(), intArrayOf())
  val containedBoxes2 = arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(), intArrayOf(), intArrayOf(), intArrayOf(), intArrayOf())
  val initialBoxes2 = intArrayOf(0)
  println(maxCandies(status2, candies2, keysInBox2, containedBoxes2, initialBoxes2)) // Expected: 6
}
