package problems

/**
 * 2033. Minimum Operations to Make a Uni-Value Grid
 * 
 * The operation allows changing any value by ±x, so every number must stay within the same "modulo group".
 * 
 * Key Observation:
 * For any two elements a and b, it must be possible to transform one into the other using steps of size x.
 * That means: (a - b) % x == 0
 * If this condition fails for any pair → answer is -1.
 * 
 * Approach:
 * 1. Flatten the grid into a 1D list
 * 2. Check feasibility using modulo condition
 * 3. Normalize values by dividing by x
 * 4. Find median (minimizes sum of absolute differences)
 * 5. Calculate total operations as sum of absolute differences from median
 */
class MinimumOperationsToMakeAUniValueGrid {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val values = mutableListOf<Int>()

        // Flatten grid
        for (row in grid) {
            for (value in row) {
                values.add(value)
            }
        }

        // Check feasibility
        val base = values[0]
        for (value in values) {
            if ((value - base) % x != 0) {
                return -1
            }
        }

        // Normalize values (convert to unit steps)
        val normalizedValues = values.map { it / x }.sorted()

        // Find median (optimal target to minimize total operations)
        val median = normalizedValues[normalizedValues.size / 2]

        // Calculate total operations
        var totalOperations = 0
        for (value in normalizedValues) {
            totalOperations += kotlin.math.abs(value - median)
        }

        return totalOperations
    }
}
