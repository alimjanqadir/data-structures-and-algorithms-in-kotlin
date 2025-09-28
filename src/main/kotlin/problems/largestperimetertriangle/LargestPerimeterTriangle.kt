package problems.largestperimetertriangle

class Solution {
  fun largestPerimeter(nums: IntArray): Int {
    nums.sort() // ascending
    var indexOfLongest = nums.lastIndex
    while (indexOfLongest >= 2) {
      val longest = nums[indexOfLongest]
      val middle = nums[indexOfLongest - 1]
      val shortest = nums[indexOfLongest - 2]
      if (shortest + middle > longest) {
        // Valid triangle; perimeter is maximal due to sorting and right-to-left scan
        return shortest + middle + longest
      }
      indexOfLongest -= 1
    }
    return 0
  }
}
