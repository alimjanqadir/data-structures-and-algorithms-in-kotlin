package problems.push

fun maxPartitionsAfterOperations(s: String, k: Int): Int {
  val n = s.length
  val left = Array(n) { IntArray(3) }
  val right = Array(n) { IntArray(3) }

  var segments = 0
  var mask = 0
  var distinctCount = 0
  for (index in 0 until n - 1) {
    val bit = 1 shl (s[index] - 'a')
    if ((mask and bit) == 0) {
      distinctCount += 1
      if (distinctCount <= k) {
        mask = mask or bit
      } else {
        segments += 1
        mask = bit
        distinctCount = 1
      }
    }
    left[index + 1][0] = segments
    left[index + 1][1] = mask
    left[index + 1][2] = distinctCount
  }

  segments = 0
  mask = 0
  distinctCount = 0
  for (index in n - 1 downTo 1) {
    val bit = 1 shl (s[index] - 'a')
    if ((mask and bit) == 0) {
      distinctCount += 1
      if (distinctCount <= k) {
        mask = mask or bit
      } else {
        segments += 1
        mask = bit
        distinctCount = 1
      }
    }
    right[index - 1][0] = segments
    right[index - 1][1] = mask
    right[index - 1][2] = distinctCount
  }

  var best = 0
  for (index in 0 until n) {
    var current = left[index][0] + right[index][0] + 2
    val mergedMask = left[index][1] or right[index][1]
    val mergedDistinct = Integer.bitCount(mergedMask)

    if (left[index][2] == k && right[index][2] == k && mergedDistinct < 26) {
      current += 1
    } else if (minOf(mergedDistinct + 1, 26) <= k) {
      current -= 1
    }
    best = maxOf(best, current)
  }
  return best
}
