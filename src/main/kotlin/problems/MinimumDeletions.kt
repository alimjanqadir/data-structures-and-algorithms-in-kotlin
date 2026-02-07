package problems

fun minimumDeletions(input: String): Int {
  val totalLength = input.length
  // First pass: count how many 'b's exist in total
  var totalBs = 0
  for (ch in input) {
    if (ch == 'b') {
      totalBs = totalBs + 1
    }
  }
  var bestKeepCount = 0
  var leftAs = 0 // number of 'a's seen so far
  var leftBs = 0 // number of 'b's seen so far
  // We check the situation before any character (all b's can be kept)
  bestKeepCount = leftAs + (totalBs - leftBs)
  // Scan through each position
  for (ch in input) {
    if (ch == 'a') {
      leftAs = leftAs + 1
    } else {
      leftBs = leftBs + 1
    }
    // At this point we can keep:
    // - all 'a's we've seen so far (they go to the left part)
    // - all 'b's that appear after this position (right part)
    val keepableHere = leftAs + (totalBs - leftBs)
    if (keepableHere > bestKeepCount) {
      bestKeepCount = keepableHere
    }
  }
  val minimumDeletionsNeeded = totalLength - bestKeepCount
  return minimumDeletionsNeeded
}
