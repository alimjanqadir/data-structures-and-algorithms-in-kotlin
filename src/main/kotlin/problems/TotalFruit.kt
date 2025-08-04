package problems

fun totalFruit(fruits: IntArray): Int {
  val basketCounts = mutableMapOf<Int, Int>()   // fruitType → occurrences in current window
  var leftPointer = 0
  var maximumFruits = 0

  for (rightPointer in fruits.indices) {
    // Add current tree’s fruit to the window
    val currentFruit = fruits[rightPointer]
    basketCounts[currentFruit] = (basketCounts[currentFruit] ?: 0) + 1

    // Shrink window until ≤ 2 distinct fruit types remain
    while (basketCounts.size > 2) {
      val fruitAtLeft = fruits[leftPointer]
      basketCounts[fruitAtLeft] = basketCounts.getValue(fruitAtLeft) - 1
      if (basketCounts.getValue(fruitAtLeft) == 0) {
        basketCounts.remove(fruitAtLeft)
      }
      leftPointer += 1
    }

    // Record best window so far
    val currentWindowSize = rightPointer - leftPointer + 1
    if (currentWindowSize > maximumFruits) {
      maximumFruits = currentWindowSize
    }
  }

  return maximumFruits
}
