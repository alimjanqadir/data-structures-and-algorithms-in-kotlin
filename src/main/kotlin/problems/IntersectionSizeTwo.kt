package problems

class Solution {
  fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
    if (intervals.isEmpty()) return 0
        
    // Sort by end ascending, then by start descending (optional but safe)
    intervals.sortWith(compareBy({ it[1] }, { -it[0] }))
        
    val points = mutableListOf<Int>()
        
    for ((l, r) in intervals) {
      // count how many selected points are already inside [l,r]
      var covered = 0
      for (p in points) {
        if (p >= l && p <= r) covered++
      }
            
      when (covered) {
        0 -> {
          // need two numbers, place them as right as possible
          points.add(r - 1)
          points.add(r)
        }
        1 -> {
          // need one more, place it at the right end
          points.add(r)
        }
        // >=2 → already satisfied
      }
    }
    return points.size
  }
}
