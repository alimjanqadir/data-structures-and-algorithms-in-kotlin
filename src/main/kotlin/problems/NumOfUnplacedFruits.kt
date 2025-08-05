package problems

fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
  val basketOccupied = BooleanArray(baskets.size)
  var unplacedCount = 0

  for (fruitIndex in fruits.indices) {
    val fruitQuantity = fruits[fruitIndex]
    var placed = false

    for (basketIndex in baskets.indices) {
      if (!basketOccupied[basketIndex] &&
        baskets[basketIndex] >= fruitQuantity
      ) {
        basketOccupied[basketIndex] = true
        placed = true
        break
      }
    }

    if (!placed) {
      unplacedCount += 1
    }
  }
  return unplacedCount
}

