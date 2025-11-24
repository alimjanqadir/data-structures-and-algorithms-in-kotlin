package problems

fun prefixesDivBy5(nums: IntArray): List<Boolean> {
    val answer = mutableListOf<Boolean>()
    var current = 0  // represents the current prefix value modulo 5
    
    for (bit in nums) {
        // Update current = (current * 2 + bit) % 5
        current = (current * 2 + bit) % 5
        
        // If current == 0, then the number is divisible by 5
        answer.add(current == 0)
    }
    
    return answer
}
