package problems

import java.util.PriorityQueue

/**
 * LeetCode 1353. Maximum Number of Events That Can Be Attended
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 *
 * Greedy sweep line using a min-heap of end days.
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
fun maxEvents(events: Array<IntArray>): Int {
  // Sort events by start day, then end day
  events.sortWith(compareBy({ it[0] }, { it[1] }))

  val active = PriorityQueue<Int>() // stores end days
  var currentDay = 0
  var index = 0
  var attended = 0

  // Process days until all events considered and queue empty
  while (index < events.size || active.isNotEmpty()) {
    if (active.isEmpty()) {
      currentDay = events[index][0]
    }

    while (index < events.size && events[index][0] == currentDay) {
      active += events[index][1]
      index++
    }

    while (active.isNotEmpty() && active.peek() < currentDay) {
      active.poll()
    }

    if (active.isNotEmpty()) {
      active.poll()
      attended++
      currentDay++
    }
  }
  return attended
}

