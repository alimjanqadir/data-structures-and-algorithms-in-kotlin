package problems

fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
    fun buildAdjacency(edgeList: Array<IntArray>, size: Int): Array<MutableList<Int>> {
        return Array(size) { mutableListOf<Int>() }.also { adj ->
            for ((u, v) in edgeList) {
                adj[u].add(v)
                adj[v].add(u)
            }
        }
    }

    fun bfsCount(adjacency: Array<MutableList<Int>>, start: Int, depthLimit: Int): Int {
        if (depthLimit < 0) return 0
        val distance = IntArray(adjacency.size) { -1 }
        val queue: ArrayDeque<Int> = ArrayDeque()
        distance[start] = 0
        queue.add(start)

        var reachableNodes = 0
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            reachableNodes++
            if (distance[current] == depthLimit) continue
            for (neighbour in adjacency[current]) {
                if (distance[neighbour] == -1) {
                    distance[neighbour] = distance[current] + 1
                    queue.add(neighbour)
                }
            }
        }
        return reachableNodes
    }

    val nodeCountFirst = edges1.size + 1
    val nodeCountSecond = edges2.size + 1
    val firstAdj = buildAdjacency(edges1, nodeCountFirst)
    val secondAdj = buildAdjacency(edges2, nodeCountSecond)

    // 1. Baseline counts for every node in the first tree
    val baseline = IntArray(nodeCountFirst) { node ->
        bfsCount(firstAdj, node, k)
    }

    // 2. The best ball size we can ever get from the second tree
    val bestSecondTreeBall = if (k == 0) 0 else {
        var best = 0
        val radius = k - 1
        for (node in 0 until nodeCountSecond) {
            best = maxOf(best, bfsCount(secondAdj, node, radius))
        }
        best
    }

    // 3. Combine
    return IntArray(nodeCountFirst) { baseline[it] + bestSecondTreeBall }
}
