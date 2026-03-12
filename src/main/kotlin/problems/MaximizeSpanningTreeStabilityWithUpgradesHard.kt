package problems

fun maxStability(nodeCount: Int, edges: Array<IntArray>, maxUpgrades: Int): Int {

    if (nodeCount == 1) return 1
    
    if (mandatoryEdgesCreateCycle(nodeCount, edges)) return -1
    if (!graphCanConnect(nodeCount, edges)) return -1

    var lowStrength = 1
    var highStrength = 200000
    var bestStability = -1

    while (lowStrength <= highStrength) {

        val candidateStrength = lowStrength + (highStrength - lowStrength) / 2

        if (canBuildTree(candidateStrength, nodeCount, edges, maxUpgrades)) {
            bestStability = candidateStrength
            lowStrength = candidateStrength + 1
        } else {
            highStrength = candidateStrength - 1
        }
    }

    return bestStability
}

fun canBuildTree(
    targetStrength: Int,
    nodeCount: Int,
    edges: Array<IntArray>,
    maxUpgrades: Int
): Boolean {

    val unionFind = UnionFind(nodeCount)
    var upgradesUsed = 0

    // Step 1 — mandatory edges
    for (edge in edges) {
        val from = edge[0]
        val to = edge[1]
        val strength = edge[2]
        val mandatory = edge[3]

        if (mandatory == 1) {
            if (strength < targetStrength) return false
            unionFind.connect(from, to)
        }
    }

    // Step 2 — already strong edges (no upgrade needed)
    for (edge in edges) {
        val from = edge[0]
        val to = edge[1]
        val strength = edge[2]
        val mandatory = edge[3]

        if (mandatory == 0 && strength >= targetStrength) {
            unionFind.connect(from, to)
        }
    }

    // Step 3 — edges that need upgrades
    for (edge in edges) {
        val from = edge[0]
        val to = edge[1]
        val strength = edge[2]
        val mandatory = edge[3]

        if (mandatory == 0 && strength < targetStrength) {
            if (strength * 2 >= targetStrength && upgradesUsed < maxUpgrades) {
                unionFind.connect(from, to)
                upgradesUsed++
            }
        }
    }

    return unionFind.components == 1
}

fun mandatoryEdgesCreateCycle(nodeCount: Int, edges: Array<IntArray>): Boolean {

    val unionFind = UnionFind(nodeCount)

    for (edge in edges) {
        if (edge[3] == 1) {
            val merged = unionFind.connect(edge[0], edge[1])
            if (!merged) return true
        }
    }

    return false
}

fun graphCanConnect(nodeCount: Int, edges: Array<IntArray>): Boolean {

    val unionFind = UnionFind(nodeCount)

    for (edge in edges) {
        unionFind.connect(edge[0], edge[1])
    }

    return unionFind.components == 1
}

class UnionFind(size: Int) {

    private val parent = IntArray(size) { it }
    var components = size

    fun find(node: Int): Int {

        var current = node

        while (current != parent[current]) {
            parent[current] = parent[parent[current]]
            current = parent[current]
        }

        return current
    }

    fun connect(a: Int, b: Int): Boolean {

        val rootA = find(a)
        val rootB = find(b)

        if (rootA == rootB) return false

        parent[rootA] = rootB
        components -= 1
        return true
    }
}
