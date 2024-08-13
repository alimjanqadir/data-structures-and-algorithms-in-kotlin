class Solution {
    // Function to calculate the GCD of two numbers
     fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    // Function to count the number of beautiful pairs
    fun countBeautifulPairs(nums: IntArray): Int {
        var count = 0
        // Iterate through all possible pairs (i, j)
        for (i in nums.indices) {
            while (nums[i] >= 10) {
                nums[i] /= 10
            }
            for (j in i + 1 until nums.size) {
                // Check if the GCD of the pair is 1
                if (gcd(nums[i], nums[j] % 10) == 1) {
                    count++
                }
            }
        }
        return count
    }
}

// Example usage
fun main() {
    val solution = Solution()
    println(solution.countBeautifulPairs(intArrayOf(1, 2, 3))) // Output: 3
    println(solution.countBeautifulPairs(intArrayOf(2, 4, 6))) // Output: 0
    println(solution.countBeautifulPairs(intArrayOf(3, 5, 7, 9))) // Output: 6
    println(solution.countBeautifulPairs(intArrayOf(31, 25, 72, 79, 74))) // Output: 7
}