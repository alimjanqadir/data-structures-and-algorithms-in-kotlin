package problems

import java.util.PriorityQueue

fun minRefuelStopsGreedy(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
  // Max Heap to store fuel capacities of passed stations
  val maxHeap = PriorityQueue<Int>(compareByDescending { it })
  var fuel = startFuel
  var prevLocation = 0
  var stops = 0
  var i = 0

  while (fuel < target) {
    // Add all stations within current reach to the heap
    while (i < stations.size && stations[i][0] <= fuel) {
      maxHeap.add(stations[i][1])
      i++
    }
    // If no stations to refuel from and target not reached
    if (maxHeap.isEmpty()) return -1
    // Refuel from the station with the most fuel
    fuel += maxHeap.poll()
    stops++
  }
  return stops
}


fun minRefuelStopsFunctional(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
  tailrec fun helper(
    position: Int,
    fuel: Int,
    stops: Int,
    index: Int,
    heap: PriorityQueue<Int>
  ): Int {
    if (fuel >= target) return stops
    var i = index
    var newHeap = heap
    // Collect stations within current reach
    while (i < stations.size && stations[i][0] <= fuel) {
      newHeap.add(stations[i][1])
      i++
    }
    if (newHeap.isEmpty()) return -1
    // Refuel with the station offering the most fuel
    val refueledFuel = fuel + newHeap.poll()
    return helper(position, refueledFuel, stops + 1, i, newHeap)
  }
  return helper(0, startFuel, 0, 0, PriorityQueue(compareByDescending { it }))
}

fun main() {
  // Test Case 1
  val target1 = 100
  val startFuel1 = 10
  val stations1 = arrayOf(intArrayOf(10, 60), intArrayOf(20, 30), intArrayOf(30, 30), intArrayOf(60, 40))
  assert(minRefuelStopsGreedy(target1, startFuel1, stations1) == 2)
  assert(minRefuelStopsFunctional(target1, startFuel1, stations1) == 2)

  // Test Case 2
  val target2 = 1
  val startFuel2 = 1
  val stations2 = arrayOf<IntArray>()
  assert(minRefuelStopsGreedy(target2, startFuel2, stations2) == 0)
  assert(minRefuelStopsFunctional(target2, startFuel2, stations2) == 0)

  // Test Case 3
  val target3 = 100
  val startFuel3 = 1
  val stations3 = arrayOf(intArrayOf(10, 100))
  assert(minRefuelStopsGreedy(target3, startFuel3, stations3) == -1)
  assert(minRefuelStopsFunctional(target3, startFuel3, stations3) == -1)

  println("All test cases passed!")
}