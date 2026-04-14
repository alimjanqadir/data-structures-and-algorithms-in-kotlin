package problems

/**
 * 2463. Minimum Total Distance Traveled
 *
 * This problem becomes structured once the positions are sorted.
 *
 * Core Idea:
 * - Sort robot positions
 * - Sort factories by position
 *
 * Now the problem turns into:
 * > Assign each robot to a factory (respecting capacity), minimizing total distance.
 *
 * Key Insight:
 * If both robots and factories are sorted:
 * - Optimal assignments preserve order
 * - A robot earlier in the list will never skip a closer available factory to go to a
 *   farther one while a later robot takes the closer one
 *
 * This gives a DP + prefix assignment structure.
 *
 * DP Definition:
 * dp[i][j] = minimum cost to fix first i robots using first j factories
 *
 * Transition:
 * For factory j, we can assign k robots to it:
 * - k ranges from 0 to limit_j
 * - These k robots must be the last k robots among the first i
 *
 * So:
 * dp[i][j] = min over k:
 *     dp[i - k][j - 1] + cost of assigning last k robots to factory j
 *
 * Cost Optimization:
 * For a factory at position pos, assigning robots robot[i-k], ..., robot[i-1]:
 * Cost is: sum of |robot[x] - pos|
 * We compute this incrementally while iterating k.
 *
 * Time Complexity: O(n * m * limit) where n is number of robots, m is number of factories
 * Space Complexity: O(n * m)
 *
 * @param robot List of robot positions
 * @param factory Array of factories where each factory is [position, capacity]
 * @return Minimum total distance traveled by all robots
 */
fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
    val sortedRobots = robot.sorted()
    val sortedFactories = factory.sortedBy { it[0] }

    val robotCount = sortedRobots.size
    val factoryCount = sortedFactories.size

    val dp = Array(robotCount + 1) { LongArray(factoryCount + 1) { Long.MAX_VALUE / 2 } }
    dp[0][0] = 0L

    for (factoryIndex in 1..factoryCount) {
        val factoryPosition = sortedFactories[factoryIndex - 1][0]
        val factoryLimit = sortedFactories[factoryIndex - 1][1]

        for (robotCountUsed in 0..robotCount) {
            // Case 1: skip this factory
            dp[robotCountUsed][factoryIndex] = dp[robotCountUsed][factoryIndex - 1]

            var accumulatedDistance = 0L

            // Case 2: assign k robots to this factory
            for (k in 1..minOf(factoryLimit, robotCountUsed)) {
                val robotIndex = robotCountUsed - k
                accumulatedDistance += kotlin.math.abs(
                    sortedRobots[robotIndex] - factoryPosition
                )

                dp[robotCountUsed][factoryIndex] = minOf(
                    dp[robotCountUsed][factoryIndex],
                    dp[robotCountUsed - k][factoryIndex - 1] + accumulatedDistance
                )
            }
        }
    }

    return dp[robotCount][factoryCount]
}
