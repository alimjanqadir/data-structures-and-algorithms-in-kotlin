package problems

fun minCost(colors: String, neededTime: IntArray): Int {
  val length = colors.length
  if (length == 0) return 0

  var totalRemovalTime = 0
  var currentGroupColor = colors[0]
  var currentGroupSum = neededTime[0]
  var currentGroupMax = neededTime[0]

  for (index in 1 until length) {
    val colorAtIndex = colors[index]
    val timeAtIndex = neededTime[index]
    if (colorAtIndex == currentGroupColor) {
      // extend current group
      currentGroupSum += timeAtIndex
      if (timeAtIndex > currentGroupMax) currentGroupMax = timeAtIndex
    } else {
      // close previous group and add its minimal removal cost
      totalRemovalTime += currentGroupSum - currentGroupMax
      // start new group
      currentGroupColor = colorAtIndex
      currentGroupSum = timeAtIndex
      currentGroupMax = timeAtIndex
    }
  }
  // process last group
  totalRemovalTime += currentGroupSum - currentGroupMax

  return totalRemovalTime
}
