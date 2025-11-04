package problems

fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        val n = nums.size
        val resultLength = n - k + 1
        val answer = IntArray(resultLength)
        // freq for values 1..50 
        val frequency = IntArray(51)
         
        for (windowStart in 0 until resultLength) {
            // reset frequency 
            for (v in 1..50) frequency[v] = 0
            // count frequencies for current window 
            for (pos in windowStart until windowStart + k) {
                frequency[nums[pos]]++
            }
            // build list of (value, freq) with freq>0 
            val valueFreqList = ArrayList<Pair<Int,Int>>()
            for (value in 1..50) { 
                val freq = frequency[value]
                if (freq > 0) valueFreqList.add(Pair(value, freq)) 
            }
            // if distinct elements <= x, sum whole window 
            if (valueFreqList.size <= x) {
                var windowSum = 0 
                for ((value, freq) in valueFreqList) { 
                    windowSum += value * freq 
                } 
                answer[windowStart] = windowSum 
                continue 
            }
            // otherwise sort by freq desc, then value desc, and take top x 
            valueFreqList.sortWith(compareByDescending<Pair<Int,Int>> { it.second } 
                .thenByDescending { it.first })
            var xSum = 0 
            for (index in 0 until x) { 
                val (value, freq) = valueFreqList[index] 
                xSum += value * freq 
            } 
            answer[windowStart] = xSum 
        }
         
    return answer
}
