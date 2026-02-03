package problems

fun findDuplicates(nums: IntArray): IntArray {
  val seen = mutableSetOf<Int>()
  val result = mutableListOf<Int>()
    
  // Iterate over the array and track the repeated numbers
  for (num in nums) {
    if (num in seen) {
      result.add(num)
    } else {
      seen.add(num)
    }
  }
    
  return result.toIntArray()
}
