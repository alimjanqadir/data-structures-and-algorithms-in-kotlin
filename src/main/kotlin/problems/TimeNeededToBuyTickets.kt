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

fun main() {
    // Test Case 1: Example 1
    val tickets1 = intArrayOf(2, 3, 2)
    val k1 = 2
    val expected1 = 6
    assert(timeRequiredToBuyBruteForce(tickets1, k1) == expected1) { "Brute Force Failed on Test Case 1" }
    assert(timeRequiredToBuyEfficient(tickets1, k1) == expected1) { "Efficient Failed on Test Case 1" }
    assert(timeRequiredToBuyFunctional(tickets1, k1) == expected1) { "Functional Failed on Test Case 1" }

    // Test Case 2: Example 2
    val tickets2 = intArrayOf(5, 1, 1, 1)
    val k2 = 0
    val expected2 = 8
    assert(timeRequiredToBuyBruteForce(tickets2, k2) == expected2) { "Brute Force Failed on Test Case 2" }
    assert(timeRequiredToBuyEfficient(tickets2, k2) == expected2) { "Efficient Failed on Test Case 2" }
    assert(timeRequiredToBuyFunctional(tickets2, k2) == expected2) { "Functional Failed on Test Case 2" }

    // Test Case 3: Single Person
    val tickets3 = intArrayOf(1)
    val k3 = 0
    val expected3 = 1
    assert(timeRequiredToBuyBruteForce(tickets3, k3) == expected3) { "Brute Force Failed on Test Case 3" }
    assert(timeRequiredToBuyEfficient(tickets3, k3) == expected3) { "Efficient Failed on Test Case 3" }
    assert(timeRequiredToBuyFunctional(tickets3, k3) == expected3) { "Functional Failed on Test Case 3" }

    // Test Case 4: All Ones
    val tickets4 = IntArray(100) { 1 }
    val k4 = 99
    val expected4 = 100
    assert(timeRequiredToBuyBruteForce(tickets4, k4) == expected4) { "Brute Force Failed on Test Case 4" }
    assert(timeRequiredToBuyEfficient(tickets4, k4) == expected4) { "Efficient Failed on Test Case 4" }
    assert(timeRequiredToBuyFunctional(tickets4, k4) == expected4) { "Functional Failed on Test Case 4" }

    // Test Case 5: First Person Requires More Tickets
    val tickets5 = intArrayOf(4, 1, 1, 1)
    val k5 = 0
    val expected5 = 7
    assert(timeRequiredToBuyBruteForce(tickets5, k5) == expected5) { "Brute Force Failed on Test Case 5" }
    assert(timeRequiredToBuyEfficient(tickets5, k5) == expected5) { "Efficient Failed on Test Case 5" }
    assert(timeRequiredToBuyFunctional(tickets5, k5) == expected5) { "Functional Failed on Test Case 5" }

    // Test Case 6: Target at the End with Varying Tickets
    val tickets6 = intArrayOf(1, 2, 3, 4, 5)
    val k6 = 4
    val expected6 = 15
    assert(timeRequiredToBuyBruteForce(tickets6, k6) == expected6) { "Brute Force Failed on Test Case 6" }
    assert(timeRequiredToBuyEfficient(tickets6, k6) == expected6) { "Efficient Failed on Test Case 6" }
    assert(timeRequiredToBuyFunctional(tickets6, k6) == expected6) { "Functional Failed on Test Case 6" }

    // Test Case 7: Large Number of Tickets
    val tickets7 = intArrayOf(1000, 1, 1)
    val k7 = 0
    val expected7 = 1002
    assert(timeRequiredToBuyBruteForce(tickets7, k7) == expected7) { "Brute Force Failed on Test Case 7" }
    assert(timeRequiredToBuyEfficient(tickets7, k7) == expected7) { "Efficient Failed on Test Case 7" }
    assert(timeRequiredToBuyFunctional(tickets7, k7) == expected7) { "Functional Failed on Test Case 7" }

    // Test Case 8: Target in the Middle
    val tickets8 = intArrayOf(3, 2, 2, 3)
    val k8 = 2
    val expected8 = 7
    assert(timeRequiredToBuyBruteForce(tickets8, k8) == expected8) { "Brute Force Failed on Test Case 8" }
    assert(timeRequiredToBuyEfficient(tickets8, k8) == expected8) { "Efficient Failed on Test Case 8" }
    assert(timeRequiredToBuyFunctional(tickets8, k8) == expected8) { "Functional Failed on Test Case 8" }

    println("All test cases passed!")
}