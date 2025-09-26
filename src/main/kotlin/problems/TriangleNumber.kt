package problems

fun triangleNumber(nums: IntArray): Int {
  if (nums.size < 3) return 0

  nums.sort()
  var totalTriplets = 0

  for (largestIndex in nums.lastIndex downTo 2) {
    var leftIndex = 0
    var rightIndex = largestIndex - 1

    while (leftIndex < rightIndex) {
      val smallest = nums[leftIndex]
      val middle = nums[rightIndex]
      val largest = nums[largestIndex]

      if (smallest + middle > largest) {
        totalTriplets += rightIndex - leftIndex
        rightIndex -= 1
      } else {
        leftIndex += 1
      }
    }
  }

  return totalTriplets
}
