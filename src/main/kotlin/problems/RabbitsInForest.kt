fun numRabbits(answers: IntArray): Int {
  // build frequency map
  val freq: Map<Int, Int> = answers
    .toList()                             // IntArray → List<Int>
    .groupingBy { it }
    .eachCount()

  var total = 0
  for ((a, count) in freq) {
    val groupSize = a + 1
    // how many full groups of size (a+1) we need?
    val numGroups = (count + groupSize - 1) / groupSize
    total += numGroups * groupSize
  }
  return total
}
