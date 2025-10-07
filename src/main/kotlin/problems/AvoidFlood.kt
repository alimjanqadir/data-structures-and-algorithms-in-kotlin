package problems

import java.util.TreeSet

fun avoidFlood(rains: IntArray): IntArray {
  val totalDays = rains.size
  val answer = IntArray(totalDays) { 0 }
  val lastRainDay = HashMap<Int, Int>()
  val availableDryDays = TreeSet<Int>()

  for (dayIndex in rains.indices) {
    val lakeId = rains[dayIndex]
    if (lakeId > 0) {
      answer[dayIndex] = -1
      val previousRainDay = lastRainDay[lakeId]
      if (previousRainDay != null) {
        val chosenDryDay = availableDryDays.higher(previousRainDay)
        if (chosenDryDay == null) {
          return intArrayOf()
        }
        answer[chosenDryDay] = lakeId
        availableDryDays.remove(chosenDryDay)
      }
      lastRainDay[lakeId] = dayIndex
    } else {
      availableDryDays.add(dayIndex)
      answer[dayIndex] = 1
    }
  }

  return answer
}
