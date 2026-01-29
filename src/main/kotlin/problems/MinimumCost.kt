fun minimumCost(
    source: String,
    target: String,
    original: CharArray,
    changed: CharArray,
    cost: IntArray
): Long {
    val INF = 1_000_000_000_000L          // 比 10^5 * 10^6 大很多
    val dist = Array(26) { LongArray(26) { INF } }

    // 初始化
    for (i in 0..25) {
        dist[i][i] = 0
    }

    // 建图：取最小边（可能有多条相同 x→y）
    for (i in original.indices) {
        val x = original[i] - 'a'
        val y = changed[i] - 'a'
        val c = cost[i].toLong()
        dist[x][y] = minOf(dist[x][y], c)
    }

    // Floyd-Warshall
    for (k in 0..25) {
        for (i in 0..25) {
            for (j in 0..25) {
                if (dist[i][k] < INF && dist[k][j] < INF) {
                    dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
                }
            }
        }
    }

    // 计算总代价
    var total = 0L
    for (i in source.indices) {
        val s = source[i] - 'a'
        val t = target[i] - 'a'
        if (dist[s][t] >= INF) {
            return -1L
        }
        total += dist[s][t]
    }

    return total
}
