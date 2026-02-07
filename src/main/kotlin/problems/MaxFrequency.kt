package problems

fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
  val totalOps = numOperations
  if (nums.isEmpty()) return 0

  val baseFrequency = HashMap<Long, Int>()
  for (value in nums) {
    val key = value.toLong()
    baseFrequency[key] = (baseFrequency[key] ?: 0) + 1
  }
  val uniqueValues = baseFrequency.keys.toMutableList().also { it.sort() }

  val deltaMap = HashMap<Long, Int>()
  val kLong = k.toLong()
  for (value in nums) {
    val v = value.toLong()
    val left = v - kLong
    val rightPlusOne = v + kLong + 1L
    deltaMap[left] = (deltaMap[left] ?: 0) + 1
    deltaMap[rightPlusOne] = (deltaMap[rightPlusOne] ?: 0) - 1
  }
  val events = deltaMap.entries.map { it.key to it.value }.sortedBy { it.first }

  val coverAtValue = HashMap<Long, Int>(uniqueValues.size)
  var runningCover = 0
  var eventIndex = 0
  var maxCover = 0

  for (q in uniqueValues) {
    while (eventIndex < events.size && events[eventIndex].first <= q) {
      runningCover += events[eventIndex].second
      if (runningCover > maxCover) maxCover = runningCover
      eventIndex += 1
    }
    coverAtValue[q] = runningCover
  }

  while (eventIndex < events.size) {
    runningCover += events[eventIndex].second
    if (runningCover > maxCover) maxCover = runningCover
    eventIndex += 1
  }

  var best = 0
  for (v in uniqueValues) {
    val base = baseFrequency[v] ?: 0
    val coverHere = coverAtValue[v] ?: 0
    val candidate = minOf(coverHere, base + totalOps)
    if (candidate > best) best = candidate
  }

  best = maxOf(best, minOf(maxCover, totalOps))

  return best
}
