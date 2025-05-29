package problems

fun maxTargetNodesII(edgesFirstTree: Array<IntArray>, edgesSecondTree: Array<IntArray>): IntArray {
    // Assigns bipartite colors (0 or 1) to each node by depth and counts nodes of each color
    fun assignBipartiteColors(
        nodeCount: Int,
        edges: Array<IntArray>
    ): Pair<IntArray, IntArray> {
        val adjacencyList = Array(nodeCount) { mutableListOf<Int>() }
        for ((firstNode, secondNode) in edges) {
            adjacencyList[firstNode].add(secondNode)
            adjacencyList[secondNode].add(firstNode)
        }

        val nodeColor = IntArray(nodeCount) { -1 }
        val colorCounts = IntArray(2)
        val nodeStack = ArrayDeque<Int>()

        nodeColor[0] = 0
        nodeStack.add(0)


        while (nodeStack.isNotEmpty()) {
            val currentNode = nodeStack.removeLast()
            val currentColor = nodeColor[currentNode]
            colorCounts[currentColor]++

            for (neighbor in adjacencyList[currentNode]) {
                if (nodeColor[neighbor] == -1) {
                    nodeColor[neighbor] = currentColor xor 1
                    nodeStack.add(neighbor)
                }
            }
        }


        return Pair(nodeColor, colorCounts)
    }


    val firstTreeNodeCount = edgesFirstTree.size + 1
    val secondTreeNodeCount = edgesSecondTree.size + 1

    val (firstTreeColors, firstTreeColorCounts) =
        assignBipartiteColors(firstTreeNodeCount, edgesFirstTree)
    val (_, secondTreeColorCounts) =
        assignBipartiteColors(secondTreeNodeCount, edgesSecondTree)

    val maximumSecondTreeColorCount =
        maxOf(secondTreeColorCounts[0], secondTreeColorCounts[1])


    return IntArray(firstTreeNodeCount) { nodeIndex ->
        val queryNodeColor = firstTreeColors[nodeIndex]
        firstTreeColorCounts[queryNodeColor] + maximumSecondTreeColorCount
    }
}
