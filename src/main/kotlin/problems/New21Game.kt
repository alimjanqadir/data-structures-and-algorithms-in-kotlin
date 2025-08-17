package problems

fun new21Game(n: Int, k: Int, maxPts: Int): Double {
  if (k == 0 || n >= k - 1 + maxPts) return 1.0

  val probabilities = DoubleArray(n + 1)
  probabilities[0] = 1.0

  var rollingWindowSum = 1.0
  var probabilityAtMostN = 0.0

  for (total in 1..n) {
    probabilities[total] = rollingWindowSum / maxPts

    if (total < k) {
      rollingWindowSum += probabilities[total]
    } else {
      probabilityAtMostN += probabilities[total]
    }

    val removeIndex = total - maxPts
    if (removeIndex >= 0 && removeIndex < k) {
      rollingWindowSum -= probabilities[removeIndex]
    }
  }

  return probabilityAtMostN
}
