package problems

fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
  var ans = 1  // the whole tree itself
  val adj = Array(n) { mutableListOf<Int>() }
    
  for ((a, b) in edges) {
    adj[a].add(b)
    adj[b].add(a)
  }
    
  fun dfs(u: Int, parent: Int, values: IntArray, k: Long): Long {
    var sum = values[u].toLong()
    for (v in adj[u]) {
      if (v == parent) continue
      val childSum = dfs(v, u, values, k)
      if (childSum % k == 0L) {
        ans++  // cut this edge
      }
      sum += childSum
    }
    return sum
  }
    
  dfs(0, -1, values, k.toLong())
  return ans
}
