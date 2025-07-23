package problems

/**
 * Brute Force Solution:
 * Simulates the queue by iteratively processing each person until the k-th person finishes.
 *
 * @param tickets An array where tickets\[i\] represents the number of tickets person i wants to buy.
 * @param k The index of the target person.
 * @return The total time in seconds required for the k-th person to finish buying all tickets.
 */
fun timeRequiredToBuyBruteForce(tickets: IntArray, k: Int): Int {
  var time = 0
  val remaining = tickets.copyOf() // Copy to avoid modifying the original array

  while (remaining[k] > 0) { // Continue until the k-th person has no tickets left
    for (i in remaining.indices) {
      if (remaining[i] > 0) {
        time += 1
        remaining[i] -= 1
        if (i == k && remaining[i] == 0) {
          return time // Return immediately when k-th person finishes
        }
      }
    }
  }

  return time
}

/**
 * Most Efficient Solution:
 * Calculates the total time by summing the minimum of each person's tickets and the target person's tickets.
 *
 * @param tickets An array where tickets\[i\] represents the number of tickets person i wants to buy.
 * @param k The index of the target person.
 * @return The total time in seconds required for the k-th person to finish buying all tickets.
 */
fun timeRequiredToBuyEfficient(tickets: IntArray, k: Int): Int {
  val target = tickets[k]
  var time = 0

  for (i in tickets.indices) {
    time += if (i < k) {
      // Persons before the target can buy up to their ticket count or target's ticket count
      minOf(tickets[i], target)
    } else if (i == k) {
      // The target person can buy exactly their ticket count
      tickets[i]
    } else {
      // Persons after the target can buy up to target's ticket count minus one
      minOf(tickets[i], target - 1)
    }
  }

  return time
}

/**
 * Functional Composition Solution:
 * Uses functional programming constructs to calculate total time.
 *
 * @param tickets An array where tickets\[i\] represents the number of tickets person i wants to buy.
 * @param k The index of the target person.
 * @return The total time in seconds required for the k-th person to finish buying all tickets.
 */
fun timeRequiredToBuyFunctional(tickets: IntArray, k: Int): Int {
  val target = tickets[k]
  return tickets.mapIndexed { index, ticketCount ->
    when {
      index < k -> minOf(ticketCount, target)
      index == k -> ticketCount
      else -> minOf(ticketCount, target - 1)
    }
  }.sum()
}

