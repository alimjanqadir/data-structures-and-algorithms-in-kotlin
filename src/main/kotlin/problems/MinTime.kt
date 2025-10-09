fun minTime(skill: IntArray, mana: IntArray): Long {
  val wizardCount = skill.size
  val potionCount = mana.size

  val skillPrefix = LongArray(wizardCount)
  var runningSkillSum = 0L
  for (i in 0 until wizardCount) {
    runningSkillSum += skill[i].toLong()
    skillPrefix[i] = runningSkillSum
  }

  var startTimeOfCurrent = 0L

  for (j in 1 until potionCount) {
    val prevMana = mana[j - 1].toLong()
    val currMana = mana[j].toLong()

    var requiredGap = Long.MIN_VALUE
    for (i in 0 until wizardCount) {
      val prefixHere = skillPrefix[i]
      val prefixBefore = if (i == 0) 0L else skillPrefix[i - 1]
      val candidate = prefixHere * prevMana - prefixBefore * currMana
      if (candidate > requiredGap) requiredGap = candidate
    }
    startTimeOfCurrent += requiredGap
  }

  val totalSkill = skillPrefix[wizardCount - 1]
  return startTimeOfCurrent + totalSkill * mana[potionCount - 1]
}
