fun minimumCost(
    source: String,
    target: String,
    original: Array<String>,
    changed: Array<String>,
    cost: IntArray
): Long {
    val n = source.length
    if (n != target.length) return -1L
    val INF = 4_000_000_000_000L // safe

    // === Graph part (unchanged) ===
    val strSet = hashSetOf<String>()
    original.forEach { strSet.add(it) }
    changed.forEach { strSet.add(it) }
    val nodes = strSet.toList()
    val sid = nodes.withIndex().associate { it.value to it.index }
    val N = nodes.size

    val g = Array(N) { LongArray(N) { INF } }
    for (i in nodes.indices) g[i][i] = 0L

    for (i in original.indices) {
        val u = sid[original[i]]!!
        val v = sid[changed[i]]!!
        g[u][v] = minOf(g[u][v], cost[i].toLong())
    }

    // Floyd-Warshall
    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (g[i][k] < INF && g[k][j] < INF) {
                    g[i][j] = minOf(g[i][j], g[i][k] + g[k][j])
                }
            }
        }
    }

    // changeCost map: from original-like string → desired string → min cost
    val changeCost = mutableMapOf<String, MutableMap<String, Long>>()
    for (i in nodes.indices) {
        for (j in nodes.indices) {
            if (g[i][j] < INF && g[i][j] != 0L) { // skip self-loops unless needed
                changeCost.getOrPut(nodes[i]) { mutableMapOf() }[nodes[j]] = g[i][j]
            }
        }
    }

    // === DP ===
    val dp = LongArray(n + 1) { INF }
    dp[0] = 0L

    // Pre-group originals by length (optional but helps readability)
    val byLen = mutableMapOf<Int, MutableList<Int>>()
    for (k in original.indices) {
        val len = original[k].length
        byLen.computeIfAbsent(len) { mutableListOf() }.add(k)
    }

    for (i in 0 until n) {
        if (dp[i] == INF) continue

        // Free single-char match
        if (source[i] == target[i]) {
            dp[i + 1] = minOf(dp[i + 1], dp[i])
        }

        // Try possible lengths — only lengths that exist
        for ((len, candidates) in byLen) {
            if (i + len > n) continue

            // Check each candidate of this length
            for (k in candidates) {
                val pat = original[k]

                // Manual char comparison — avoids substring creation until match
                var matches = true
                for (p in 0 until len) {
                    if (source[i + p] != pat[p]) {
                        matches = false
                        break
                    }
                }
                if (!matches) continue

                // Now we know source[i..i+len-1] == original[k]
                // Get the desired target substring
                val tgtSub = target.substring(i, i + len)

                // Look up min cost to reach tgtSub from original[k]
                val cc = changeCost[original[k]]?.get(tgtSub) ?: continue

                dp[i + len] = minOf(dp[i + len], dp[i] + cc)
            }
        }
    }

    return if (dp[n] >= INF / 2) -1L else dp[n]
}
