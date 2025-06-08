package problems

import java.util.PriorityQueue

fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
  val n = nums.size
  val q = queries.size
    
  // Sort queries by starting index
  queries.sortBy { it[0] }
    
  // Priority queue to select query with largest ri
  val pq = PriorityQueue<Int>(compareBy { -queries[it][1] })
    
  // Difference array to track coverage
  val diff = IntArray(n + 1)
    
  var current = 0    // Index of next query to consider
  var selected = 0   // Number of queries used
  var currentCov = 0 // Current coverage at index i
    
  // Process each index
  for (i in 0 until n) {
    // Add all queries that start at or before i
    while (current < q && queries[current][0] <= i) {
      pq.add(current)
      current++
    }
        
    // Update coverage at current index
    currentCov += diff[i]
        
    // Need more coverage?
    while (currentCov < nums[i]) {
      // Remove queries that end before i
      while (pq.isNotEmpty() && queries[pq.peek()][1] < i) {
        pq.poll()
      }
            
      // No queries left to cover i
      if (pq.isEmpty()) {
        return -1
      }
            
      // Select query with largest ri
      val idx = pq.poll()
      val li = queries[idx][0]
      val ri = queries[idx][1]
      selected++
            
      // Update coverage
      diff[li] += 1
      if (ri + 1 < n) {
        diff[ri + 1] -= 1
      }
      currentCov += 1  // Since li <= i <= ri, coverage at i increases
    }
  }
    
  return q - selected
}
