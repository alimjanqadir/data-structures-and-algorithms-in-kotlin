package problems

fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {
  val n = nums.size
  val graph = Array(n) { mutableListOf<Int>() }
  for ((u, v) in edges) {
    graph[u].add(v)
    graph[v].add(u)
  }

  val parent = IntArray(n) { -1 }
  val xor = nums.copyOf()
  val inTime = IntArray(n)
  val outTime = IntArray(n)
  var time = 0

  fun dfs(node: Int, par: Int) {
    parent[node] = par
    inTime[node] = time++
    for (next in graph[node]) {
      if (next == par) continue
      dfs(next, node)
      xor[node] = xor[node] xor xor[next]
    }
    outTime[node] = time
  }

  dfs(0, -1)
  val totalXor = xor[0]

  val child = edges.map { (a, b) -> if (parent[b] == a) b else a }

  fun isAncestor(u: Int, v: Int): Boolean {
    return inTime[u] <= inTime[v] && outTime[v] <= outTime[u]
  }

  var answer = Int.MAX_VALUE
  for (i in edges.indices) {
    val c1 = child[i]
    for (j in i + 1 until edges.size) {
      val c2 = child[j]
      val values = when {
        isAncestor(c1, c2) -> listOf(
          xor[c2],
          xor[c1] xor xor[c2],
          totalXor xor xor[c1]
        )
        isAncestor(c2, c1) -> listOf(
          xor[c1],
          xor[c2] xor xor[c1],
          totalXor xor xor[c2]
        )
        else -> listOf(
          xor[c1],
          xor[c2],
          totalXor xor xor[c1] xor xor[c2]
        )
      }
      val score = values.maxOrNull()!! - values.minOrNull()!!
      if (score < answer) answer = score
    }
  }
  return answer
}
