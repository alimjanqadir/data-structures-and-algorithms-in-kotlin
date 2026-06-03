package problems

fun earliestFinishTime(
  landStartTime: IntArray,
  landDuration: IntArray,
  waterStartTime: IntArray,
  waterDuration: IntArray
): Int {
  var earliestLandFinish = Int.MAX_VALUE
  for (index in landStartTime.indices) {
    earliestLandFinish = minOf(
      earliestLandFinish,
      landStartTime[index] + landDuration[index]
    )
  }

  var landThenWater = Int.MAX_VALUE
  for (index in waterStartTime.indices) {
    val finishTime = maxOf(
      earliestLandFinish,
      waterStartTime[index]
    ) + waterDuration[index]
    landThenWater = minOf(landThenWater, finishTime)
  }

  var earliestWaterFinish = Int.MAX_VALUE
  for (index in waterStartTime.indices) {
    earliestWaterFinish = minOf(
      earliestWaterFinish,
      waterStartTime[index] + waterDuration[index]
    )
  }

  var waterThenLand = Int.MAX_VALUE
  for (index in landStartTime.indices) {
    val finishTime = maxOf(
      earliestWaterFinish,
      landStartTime[index]
    ) + landDuration[index]
    waterThenLand = minOf(waterThenLand, finishTime)
  }

  return minOf(landThenWater, waterThenLand)
}
