package problems

fun isTrionic(nums: IntArray): Boolean {
  val totalElements = nums.size
  if (totalElements < 4) return false

  var currentIndex = 0

  // 1. First Segment: Strictly Increasing (0 to peak)
  if (nums[currentIndex] >= nums[currentIndex + 1]) return false
  while (currentIndex < totalElements - 1 && nums[currentIndex] < nums[currentIndex + 1]) {
    currentIndex += 1
  }
  if (currentIndex == totalElements - 1) return false

  // 2. Second Segment: Strictly Decreasing (peak to valley)
  if (nums[currentIndex] <= nums[currentIndex + 1]) return false
  while (currentIndex < totalElements - 1 && nums[currentIndex] > nums[currentIndex + 1]) {
    currentIndex += 1
  }
  if (currentIndex == totalElements - 1) return false

  // 3. Third Segment: Strictly Increasing (valley to end)
  if (nums[currentIndex] >= nums[currentIndex + 1]) return false
  while (currentIndex < totalElements - 1 && nums[currentIndex] < nums[currentIndex + 1]) {
    currentIndex += 1
  }

  return currentIndex == totalElements - 1
}
