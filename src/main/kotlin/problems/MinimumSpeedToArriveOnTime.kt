package problems

import kotlin.math.ceil

fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
  if (hour <= dist.size - 1) return -1
  var left = 1
  var right = 10_000_000
  var minSpeed = -1
  while (left <= right) {
    val midSpeed = left + (right - left) / 2
    if (canArriveOnTime(dist, hour, midSpeed)) {
      minSpeed = midSpeed
      right = midSpeed - 1
    } else {
      left = midSpeed + 1
    }
  }
  return minSpeed
}

private fun canArriveOnTime(dist: IntArray, hour: Double, speed: Int): Boolean {
  var totalTime = 0.0
  for (i in dist.indices) {
    val time = if (i == dist.lastIndex) {
      dist[i].toDouble() / speed
    } else {
      ceil(dist[i].toDouble() / speed)
    }
    totalTime += time
  }
  return totalTime <= hour + 1e-9
}
