package problems.push

class Solution {
  fun maxArea(height: IntArray): Int {
    var leftIndex = 0
    var rightIndex = height.lastIndex
    var bestArea = 0

    while (leftIndex < rightIndex) {
      val width = rightIndex - leftIndex
      val limitingHeight = if (height[leftIndex] < height[rightIndex]) {
        height[leftIndex]
      } else {
        height[rightIndex]
      }
      val area = limitingHeight * width
      if (area > bestArea) bestArea = area

      if (height[leftIndex] <= height[rightIndex]) {
        leftIndex += 1
      } else {
        rightIndex -= 1
      }
    }
    return bestArea
  }
}
