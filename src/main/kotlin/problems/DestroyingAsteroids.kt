package problems

fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
  asteroids.sort()
  var currentMass = mass.toLong()

  for (asteroidMass in asteroids) {
    val asteroidMassAsLong = asteroidMass.toLong()
    if (currentMass < asteroidMassAsLong) {
      return false
    }
    currentMass += asteroidMassAsLong
  }

  return true
}
