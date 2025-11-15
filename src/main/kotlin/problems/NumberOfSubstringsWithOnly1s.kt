package problems

/**
 * Problem: [Number of Substrings With Only 1s](https://leetcode.com/problems/number-of-substrings-with-only-1s/)
 * 
 * This function calculates the number of substrings in a binary string that contain only '1's.
 * The solution uses a mathematical approach to efficiently count the substrings without generating them explicitly.
 * 
 * @param s The input binary string containing '0's and '1's
 * @return The number of substrings containing only '1's, modulo 10^9 + 7
 */
fun numberOfSubstrings(s: String): Int {
    val n = s.length
    val pos = mutableListOf<Int>()
    
    // Find all positions of '0's in the string
    for (i in 0 until n) {
        if (s[i] == '0') pos.add(i)
    }
    
    val k = pos.size
    var ans: Long = 0
    
    // Case 1: Substrings with no '0's (z=0)
    if (k > 0) {
        // Calculate substrings before the first '0'
        var m = pos[0]
        ans += (m.toLong() * (m + 1)) / 2
        
        // Calculate substrings between consecutive '0's
        for (i in 1 until k) {
            m = pos[i] - pos[i - 1] - 1
            ans += (m.toLong() * (m + 1)) / 2
        }
        
        // Calculate substrings after the last '0'
        m = n - pos[k - 1] - 1
        ans += (m.toLong() * (m + 1)) / 2
    } else {
        // If there are no '0's, all possible substrings are valid
        val m = n
        ans += (m.toLong() * (m + 1)) / 2
        return ans.toInt()
    }
    
    // Case 2: Substrings with exactly z '0's where z >= 1
    var z = 1
    while (z <= k && (z.toLong() * (z + 1)) <= n) {
        val M = z.toLong() * z + z
        val K = M - 1
        
        for (l in 0..(k - z)) {
            val r = l + z - 1
            val pos_l = pos[l]
            val pos_r = pos[r]
            
            // Define the window [A, D] containing exactly z '0's
            val A = if (l == 0) 0 else pos[l - 1] + 1
            val B = pos_l
            val C = pos_r
            val D = if (r == k - 1) n - 1 else pos[r + 1] - 1
            
            // Skip if the window is too small to contain the required pattern
            if ((D - A + 1).toLong() < M) continue
            
            val fixed = (D - C + 1).toLong()
            if (fixed <= 0) continue
            
            val T = C.toLong() - K
            val high1 = if (T > Int.MAX_VALUE.toLong()) Int.MAX_VALUE.toLong() 
                       else if (T < Int.MIN_VALUE.toLong()) Int.MIN_VALUE.toLong() 
                       else T
            
            // Calculate the number of valid starting positions
            val num_first = maxOf(0, minOf(B.toLong(), high1) - A + 1)
            val contrib1 = num_first * fixed
            
            // Calculate additional contributions using arithmetic series
            val start0 = maxOf(A.toLong(), C.toLong() - K + 1)
            val high2 = minOf(B.toLong(), D.toLong() - K)
            val num_terms = maxOf(0, high2 - start0 + 1)
            
            var contrib2: Long = 0
            if (num_terms > 0) {
                val sum_starts = num_terms * (start0 + high2) / 2
                val const_val = D.toLong() - K + 1
                contrib2 = num_terms * const_val - sum_starts
            }
            
            ans += contrib1 + contrib2
        }
        z++
    }
    
    return ans.toInt()
}
