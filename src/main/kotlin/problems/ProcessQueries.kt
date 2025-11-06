package problems

import java.util.*

fun processQueries(c: Int, connections: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val parent = IntArray(c + 1) { it }
    val rank = IntArray(c + 1)
    
    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }
    
    fun union(x: Int, y: Int) {
        val px = find(x)
        val py = find(y)
        if (px == py) return
        if (rank[px] < rank[py]) parent[px] = py
        else {
            parent[py] = px
            if (rank[px] == rank[py]) rank[px]++
        }
    }
    
    // Process initial connections
    for (conn in connections) {
        union(conn[0], conn[1])
    }
    
    // Find root of each component
    val rootOf = IntArray(c + 1)
    for (i in 1..c) {
        rootOf[i] = find(i)
    }
    
    // Map root to its online components
    val compMap = mutableMapOf<Int, TreeSet<Int>>()
    for (i in 1..c) {
        val root = rootOf[i]
        compMap.getOrPut(root) { TreeSet() }.add(i)
    }
    
    val ans = mutableListOf<Int>()
    for (q in queries) {
        val type = q[0]
        val x = q[1]
        val root = rootOf[x]
        val onlineSet = compMap[root]!!
        
        if (type == 2) {
            // Offline query
            onlineSet.remove(x)
        } else {
            // Online query
            if (onlineSet.isEmpty()) {
                ans.add(-1)
            } else {
                ans.add(if (onlineSet.contains(x)) x else onlineSet.first())
            }
        }
    }
    
    return ans.toIntArray()
}
