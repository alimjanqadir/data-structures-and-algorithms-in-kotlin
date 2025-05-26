package problems

fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
    val totalNodes = colors.length
    val graph = Array(totalNodes) { mutableListOf<Int>() }
    val inDegree = IntArray(totalNodes)
    
    // Build the graph
    for ((source, target) in edges) {
        graph[source].add(target)
        inDegree[target]++
    }

    // Queue for topological sort
    val queue = ArrayDeque<Int>()
    for (node in 0 until totalNodes) {
        if (inDegree[node] == 0) queue.addLast(node)
    }

    // Each node keeps track of count of all 26 colors
    val colorCount = Array(totalNodes) { IntArray(26) }
    var visitedCount = 0
    var maxColorValue = 0

    while (queue.isNotEmpty()) {
        val currentNode = queue.removeFirst()
        visitedCount++

        // Update current color count
        val currentColorIndex = colors[currentNode] - 'a'
        colorCount[currentNode][currentColorIndex]++

        maxColorValue = maxOf(maxColorValue, colorCount[currentNode][currentColorIndex])

        for (nextNode in graph[currentNode]) {
            // Update nextNode's color counts based on currentNode
            for (colorIndex in 0 until 26) {
                colorCount[nextNode][colorIndex] = maxOf(
                    colorCount[nextNode][colorIndex],
                    colorCount[currentNode][colorIndex]
                )
            }

            inDegree[nextNode]--
            if (inDegree[nextNode] == 0) {
                queue.addLast(nextNode)
            }
        }
    }

    // If we didn't visit all nodes, there was a cycle
    return if (visitedCount == totalNodes) maxColorValue else -1
}
