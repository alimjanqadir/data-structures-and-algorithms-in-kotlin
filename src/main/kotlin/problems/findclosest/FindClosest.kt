package problems

fun findClosest(x: Int, y: Int, z: Int): Int {
    val distancePerson1ToTarget = kotlin.math.abs(x - z)
    val distancePerson2ToTarget = kotlin.math.abs(y - z)

    return when {
      distancePerson1ToTarget < distancePerson2ToTarget -> 1
      distancePerson2ToTarget < distancePerson1ToTarget -> 2
      else -> 0
    }
}
