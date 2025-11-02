package problems

class Solution {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val guardsSet = HashSet<Long>()
        val occupied = HashSet<Long>()
        val rowOcc: Array<ArrayList<Int>> = Array(m) { ArrayList<Int>() }
        val colOcc: Array<ArrayList<Int>> = Array(n) { ArrayList<Int>() }
        
        for (g in guards) {
            val r = g[0]
            val c = g[1]
            val pos = r.toLong() * n + c
            guardsSet.add(pos)
            occupied.add(pos)
            rowOcc[r].add(c)
            colOcc[c].add(r)
        }
        
        for (w in walls) {
            val r = w[0]
            val c = w[1]
            val pos = r.toLong() * n + c
            occupied.add(pos)
            rowOcc[r].add(c)
            colOcc[c].add(r)
        }
        
        val guardedByRow = HashSet<Long>()
        val guardedByCol = HashSet<Long>()
        
        // Process rows
        for (r in 0 until m) {
            val occ = rowOcc[r]
            occ.sort()
            var prev = -1
            
            for (curr in occ) {
                // segment prev+1 to curr-1
                if (prev + 1 <= curr - 1) {
                    var isGuardedHor = false
                    if (prev != -1 && guardsSet.contains(r.toLong() * n + prev)) isGuardedHor = true
                    if (guardsSet.contains(r.toLong() * n + curr)) isGuardedHor = true
                    
                    if (isGuardedHor) {
                        for (cc in prev + 1 until curr) {
                            val pos = r.toLong() * n + cc
                            guardedByRow.add(pos)
                        }
                    }
                }
                prev = curr
            }
            
            // Last segment
            if (prev + 1 <= n - 1) {
                var isGuardedHor = false
                if (prev != -1 && guardsSet.contains(r.toLong() * n + prev)) isGuardedHor = true
                
                if (isGuardedHor) {
                    for (cc in prev + 1 until n) {
                        val pos = r.toLong() * n + cc
                        guardedByRow.add(pos)
                    }
                }
            }
        }
        
        // Process columns
        for (c in 0 until n) {
            val occ = colOcc[c]
            occ.sort()
            var prev = -1
            
            for (curr in occ) {
                if (prev + 1 <= curr - 1) {
                    var isGuardedVert = false
                    if (prev != -1 && guardsSet.contains(prev.toLong() * n + c)) isGuardedVert = true
                    if (guardsSet.contains(curr.toLong() * n + c)) isGuardedVert = true
                    
                    if (isGuardedVert) {
                        for (rr in prev + 1 until curr) {
                            val pos = rr.toLong() * n + c
                            guardedByCol.add(pos)
                        }
                    }
                }
                prev = curr
            }
            
            // Last segment
            if (prev + 1 <= m - 1) {
                var isGuardedVert = false
                if (prev != -1 && guardsSet.contains(prev.toLong() * n + c)) isGuardedVert = true
                
                if (isGuardedVert) {
                    for (rr in prev + 1 until m) {
                        val pos = rr.toLong() * n + c
                        guardedByCol.add(pos)
                    }
                }
            }
        }
        
        // Count unguarded cells
        var count = 0
        for (r in 0 until m) {
            for (c in 0 until n) {
                val pos = r.toLong() * n + c
                if (!occupied.contains(pos) && !guardedByRow.contains(pos) && !guardedByCol.contains(pos)) {
                    count++
                }
            }
        }
        
        return count
    }
}
