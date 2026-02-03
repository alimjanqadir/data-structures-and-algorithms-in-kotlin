package problems

fun countTrapezoids(points: Array<IntArray>): Int {
  // 按 y 分组统计每条水平线上的点数
  val map = mutableMapOf<Int, Int>()
  for ((_, y) in points) {
    map[y] = map.getOrDefault(y, 0) + 1
  }

  var sumComb2 = 0L      // sum of C(cnt, 2) for all lines with cnt >= 2
  var sumComb2Sq = 0L    // sum of C(cnt, 2)^2

  for (cnt in map.values) {
    if (cnt >= 2) {
      val c2 = cnt.toLong() * (cnt - 1) / 2
      sumComb2 += c2
      sumComb2Sq += c2 * c2
    }
  }

  // 总对数 = (sum C_i2)^2 - sum (C_i2)^2 ) / 2
  var total = (sumComb2 * sumComb2 - sumComb2Sq) / 2
  total %= MOD

  return total.toInt()
}

private const val MOD = 1_000_000_007L
