package problems

import java.util.TreeMap

/**
 * Returns the maximum number of tasks that can be completed given the task strengths,
 * worker strengths, available pills, and pill boost.
 */
fun maxTaskAssign(
    taskStrengths: IntArray,
    workerStrengths: IntArray,
    availablePills: Int,
    pillBoost: Int
): Int {
    /* ----------  pre-sorting  ---------------------------------------------------- */
    val tasksSorted = taskStrengths.sorted()              // ascending
    val workersSorted = workerStrengths.sorted()          // ascending

    /* ----------  helper: can we finish `taskCount` tasks?  ----------------------- */
    fun canFinish(taskCount: Int): Boolean {
        if (taskCount == 0) return true

        // 1️⃣ pick the k easiest tasks
        val easiestTasks = tasksSorted.take(taskCount)

        // 2️⃣ multiset of the k strongest workers
        val pool = TreeMap<Int, Int>()
        for (w in workersSorted.takeLast(taskCount)) {
            pool[w] = (pool[w] ?: 0) + 1
        }

        var pillsLeft = availablePills

        // 3️⃣ try them hardest-first
        for (required in easiestTasks.asReversed()) {
            val strongest = pool.lastKey()
            if (strongest >= required) {
                // unaided assignment
                pool[strongest] = pool[strongest]!! - 1
                if (pool[strongest] == 0) pool.remove(strongest)
                continue
            }
            // need a pill
            if (pillsLeft == 0) return false
            val needBase = required - pillBoost
            val candidate = pool.ceilingEntry(needBase)
                ?: return false              // no one can reach under boost
            // give pill & assign
            val s = candidate.key
            pool[s] = candidate.value - 1
            if (pool[s] == 0) pool.remove(s)
            pillsLeft -= 1
        }

        return true
    }

    /* ----------  outer binary search on the answer  ------------------------------ */
    var low = 0
    var high = minOf(taskStrengths.size, workerStrengths.size)

    while (low < high) {
        val mid = low + (high - low + 1) / 2          // upper mid
        if (canFinish(mid)) {
            low = mid                                 // mid is feasible – try larger
        } else {
            high = mid - 1                            // mid not feasible – go smaller
        }
    }
    return low
}
