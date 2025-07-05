package problems

/**
 * Returns the largest integer whose frequency in `arr`
 * equals its own value, or -1 if no such integer exists.
 */
fun findLucky(arr: IntArray): Int {
  // Step 1: frequency counting (values are bounded by 500)
  val frequency = IntArray(501)
  for (number in arr) {
    frequency[number] += 1
  }

  // Step 2: find the largest lucky integer
  var largestLucky = -1
  for (value in 1..500) {
    if (frequency[value] == value) {
      largestLucky = value   // keep the largest seen so far
    }
  }

  return largestLucky
}
