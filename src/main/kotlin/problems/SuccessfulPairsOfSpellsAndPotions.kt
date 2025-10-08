fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
  potions.sort()

  val result = IntArray(spells.size)
  val totalPotions = potions.size

  for (spellIndex in spells.indices) {
    val spellStrength = spells[spellIndex].toLong()
    val minPotionNeeded = if (spellStrength == 0L) {
      Long.MAX_VALUE
    } else {
      (success + spellStrength - 1L) / spellStrength
    }

    if (minPotionNeeded > Int.MAX_VALUE.toLong()) {
      result[spellIndex] = 0
      continue
    }

    val firstIndex = lowerBoundForLongTarget(potions, minPotionNeeded)
    result[spellIndex] = totalPotions - firstIndex
  }

  return result
}

private fun lowerBoundForLongTarget(sortedPotions: IntArray, target: Long): Int {
  var left = 0
  var right = sortedPotions.size
  while (left < right) {
    val mid = left + (right - left) / 2
    if (sortedPotions[mid].toLong() < target) {
      left = mid + 1
    } else {
      right = mid
    }
  }
  return left
}
