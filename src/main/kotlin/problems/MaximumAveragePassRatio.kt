package problems

import java.util.PriorityQueue
import kotlin.Comparator

private data class ClassState(var passed: Int, var total: Int) {
  fun gain(): Double {
    val p = passed.toDouble()
    val t = total.toDouble()
    return (p + 1.0) / (t + 1.0) - p / t
  }

  fun ratio(): Double = passed.toDouble() / total.toDouble()
}

fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
  val byGainDesc = Comparator<ClassState> { a, b ->
    val diff = b.gain().compareTo(a.gain())
    if (diff != 0) diff else 0
  }
  val classHeap = PriorityQueue(byGainDesc)

  for (entry in classes) {
    classHeap.add(ClassState(entry[0], entry[1]))
  }

  var remaining = extraStudents
  while (remaining > 0) {
    val best = classHeap.poll()
    best.passed += 1
    best.total += 1
    classHeap.add(best)
    remaining -= 1
  }

  var sumOfRatios = 0.0
  for (state in classHeap) {
    sumOfRatios += state.ratio()
  }
  return sumOfRatios / classes.size.toDouble()
}

