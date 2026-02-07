package problems

fun maximumEnergy(energy: IntArray, k: Int): Int {
  val size = energy.size
  var bestOverall = Int.MIN_VALUE

  for (residue in 0 until k) {
    var lastIndex = residue + ((size - 1 - residue) / k) * k

    var suffixSum = 0
    var bestForResidue = Int.MIN_VALUE

    var index = lastIndex
    while (index >= 0) {
      suffixSum += energy[index]
      if (suffixSum > bestForResidue) {
        bestForResidue = suffixSum
      }
      index -= k
    }

    if (bestForResidue > bestOverall) {
      bestOverall = bestForResidue
    }
  }
  return bestOverall
}
