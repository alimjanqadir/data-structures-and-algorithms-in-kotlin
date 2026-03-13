import kotlin.math.sqrt

fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {

    var leftTime = 0L
    var rightTime = workerTimes.min().toLong() * mountainHeight.toLong() * (mountainHeight + 1) / 2

    while (leftTime < rightTime) {

        val midTime = leftTime + (rightTime - leftTime) / 2

        if (canRemoveMountain(midTime, mountainHeight, workerTimes)) {
            rightTime = midTime
        } else {
            leftTime = midTime + 1
        }
    }

    return leftTime
}

private fun canRemoveMountain(
    allowedTime: Long,
    mountainHeight: Int,
    workerTimes: IntArray
): Boolean {

    var removedHeight = 0L

    for (workerTime in workerTimes) {

        val limit = allowedTime / workerTime

        val layersRemoved = ((sqrt(1.0 + 8.0 * limit) - 1) / 2).toLong()

        removedHeight += layersRemoved

        if (removedHeight >= mountainHeight) {
            return true
        }
    }

    return removedHeight >= mountainHeight
}
