package problems

fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
  var prefix = 0L
  var minPrefix = 0L
  var maxPrefix = 0L

  for (diff in differences) {
    prefix += diff
    minPrefix = minOf(minPrefix, prefix)
    maxPrefix = maxOf(maxPrefix, prefix)
  }

  val low = lower - minPrefix
  val high = upper - maxPrefix

  return if (low > high) 0 else (high - low + 1).toInt()
}
