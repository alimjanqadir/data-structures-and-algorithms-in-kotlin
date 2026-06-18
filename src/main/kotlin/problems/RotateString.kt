fun rotateString(s: String, goal: String): Boolean {
  if (s.length != goal.length) {
    return false
  }

  val doubledString = s + s

  return doubledString.contains(goal)
}
