package problems

/**
 * LeetCode Problem: Minimum Operations to Make Array Increasing
 * 
 * This solution uses a monotonic stack to keep track of increasing sequence.
 * It counts the minimum number of operations needed to make the array strictly increasing.
 */
fun minOperations(nums: IntArray): Int {
  var ans = 0
  val stack: java.util.Deque<Int> = java.util.ArrayDeque()
  stack.push(0) // sentinel

  for (num in nums) {
    while (!stack.isEmpty() && stack.peek() > num) {
      stack.pop()
    }
    if (stack.isEmpty() || stack.peek() < num) {
      ans++
      stack.push(num)
    }
  }
  return ans
}
