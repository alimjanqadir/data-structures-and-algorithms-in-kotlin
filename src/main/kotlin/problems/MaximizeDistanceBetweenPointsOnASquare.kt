package problems

class Solution {

    fun maxDistance(side: Int, points: Array<IntArray>, k: Int): Int {
        val sideLong = side.toLong()
        val perimeter = 4L * sideLong

        val positions = LongArray(points.size)
        for (index in points.indices) {
            val x = points[index][0].toLong()
            val y = points[index][1].toLong()
            positions[index] = when {
                y == 0L -> x
                x == sideLong -> sideLong + y
                y == sideLong -> 3L * sideLong - x
                else -> 4L * sideLong - y
            }
        }

        positions.sort()

        val extended = LongArray(points.size * 2)
        for (index in positions.indices) {
            extended[index] = positions[index]
            extended[index + positions.size] = positions[index] + perimeter
        }

        fun lowerBound(target: Long, left: Int, right: Int): Int {
            var l = left
            var r = right
            while (l < r) {
                val mid = (l + r) / 2
                if (extended[mid] >= target) r = mid
                else l = mid + 1
            }
            return l
        }

        fun canPick(distance: Long): Boolean {
            val n = positions.size

            for (start in 0 until n) {
                var count = 1
                var currentIndex = start
                var lastPosition = extended[start]

                while (count < k) {
                    val nextIndex = lowerBound(
                        lastPosition + distance,
                        currentIndex + 1,
                        start + n
                    )

                    if (nextIndex == start + n) break

                    lastPosition = extended[nextIndex]
                    currentIndex = nextIndex
                    count += 1
                }

                if (count == k &&
                    extended[start] + perimeter - lastPosition >= distance
                ) {
                    return true
                }
            }

            return false
        }

        var left = 0L
        var right = perimeter / 2

        while (left < right) {
            val mid = (left + right + 1) / 2
            if (canPick(mid)) {
                left = mid
            } else {
                right = mid - 1
            }
        }

        return left.toInt()
    }
}
