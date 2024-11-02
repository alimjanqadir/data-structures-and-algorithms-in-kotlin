package problems

fun nthPersonGetsNthSeat(n: Int): Double {
  return if (n == 1) 1.0 else 0.5
}

fun main() {
  val n = 10
  // Test assertions
  assert(nthPersonGetsNthSeat(1) == 1.0) { "Test failed for n = 1" }
  assert(nthPersonGetsNthSeat(2) == 0.5) { "Test failed for n = 2" }
  assert(nthPersonGetsNthSeat(10) == 0.5) { "Test failed for n = 10" }
  assert(nthPersonGetsNthSeat(100) == 0.5) { "Test failed for n = 100" }
  println("All tests passed.")
}

/**
 * Explanation:
 * The problem is about finding the probability that the nth person will sit in their assigned seat.
 * There are n passengers and n seats, and the first passenger picks a seat randomly.
 * Subsequent passengers will either sit in their assigned seat if it is available or pick a random available seat if their seat is taken.
 *
 * Let's break down the solution:
 *
 * - If n == 1, there is only one passenger and one seat, so the probability that the first person sits in their own seat is obviously 1.0.
 *
 * - For n > 1, the situation becomes more complex due to the randomness of the first passenger's choice.
 *   However, after analyzing the problem, we can see that the probability that the nth person ends up in their own seat converges to 0.5.
 *
 * Math Behind the Solution:
 * The key to understanding the solution is to look at the problem recursively.
 * Let's denote P(n) as the probability that the nth person will get their own seat.
 *
 * - When the first person (passenger 1) picks a seat, they have n possible choices:
 *   1. They can pick their own seat (probability = 1/n), in which case everyone else will sit in their assigned seats, and the nth person will definitely get their own seat.
 *   2. They can pick the nth person's seat (probability = 1/n), in which case the nth person will not get their own seat.
 *   3. They can pick any other person's seat (probability = (n-2)/n). In this case, the problem effectively reduces to having (n-1) passengers and (n-1) seats, with the same conditions.
 *
 * Therefore, we can write the probability recursively as:
 * P(n) = (1/n) * 1 + (1/n) * 0 + ((n-2)/n) * P(n-1)
 *
 * Simplifying this expression, we get:
 * P(n) = P(n-1)
 *
 * After evaluating this recursively, we find that P(2) = 0.5, and this value remains consistent for all n > 1. Thus, for n > 1, P(n) = 0.5.
 *
 * The result shows that regardless of the value of n (as long as n > 1), the probability that the nth person gets their own seat is always 0.5.
 *
 * Underlying Knowledge and How to Learn It:
 * The underlying concept behind this problem is **recursion** and **probability theory**. To understand this solution, it's helpful to learn:
 *
 * 1. **Basic Probability**: Understanding simple probability concepts, like how to calculate the chance of an event happening, is crucial. You can start by learning about independent and dependent events.
 *
 * 2. **Recursive Thinking**: This problem involves recursive thinking, where the solution to a problem depends on smaller instances of the same problem. Learning recursion can help you understand how the problem breaks down into smaller parts.
 *
 * 3. **Simulation for Understanding**: If the math feels too abstract, you can also write simple simulations in code to understand how the seat assignments play out. This way, you can observe patterns and get an intuition for why the probability is 0.5.
 *
 * Resources to Get Started:
 * - **Khan Academy**: They offer great lessons on probability and basic algebra.
 * - **YouTube Tutorials**: Look for beginner-friendly tutorials on recursion and probability.
 * - **Practice Problems**: Websites like LeetCode, Codecademy, or HackerRank have beginner-level problems that help you build foundational math and programming skills.
 */