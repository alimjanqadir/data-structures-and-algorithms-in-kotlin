package problems

fun earliestFinishTime(
  landStartTime: IntArray,
  landDuration: IntArray,
  waterStartTime: IntArray,
  waterDuration: IntArray
): Int {
  var bestLandFinish = Int.MAX_VALUE
  for (index in landStartTime.indices) {
    bestLandFinish = minOf(bestLandFinish, landStartTime[index] + landDuration[index])
  }

  var bestWaterFinish = Int.MAX_VALUE
  for (index in waterStartTime.indices) {
    bestWaterFinish = minOf(bestWaterFinish, waterStartTime[index] + waterDuration[index])
  }

  var answer = Int.MAX_VALUE

  for (index in waterStartTime.indices) {
    val finishTime = maxOf(bestLandFinish, waterStartTime[index]) + waterDuration[index]
    answer = minOf(answer, finishTime)
  }

  for (index in landStartTime.indices) {
    val finishTime = maxOf(bestWaterFinish, landStartTime[index]) + landDuration[index]
    answer = minOf(answer, finishTime)
  }

  return answer
}
