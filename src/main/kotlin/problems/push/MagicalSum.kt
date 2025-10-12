package problems.push

private const val MOD = 1_000_000_007L

fun magicalSum(m: Int, k: Int, nums: IntArray): Int {
  val n = nums.size

  val fact = LongArray(m + 1)
  val invFact = LongArray(m + 1)
  fact[0] = 1L
  for (count in 1..m) {
    fact[count] = fact[count - 1] * count % MOD
  }
  invFact[m] = modPow(fact[m], MOD - 2)
  for (count in m - 1 downTo 0) {
    invFact[count] = invFact[count + 1] * (count + 1) % MOD
  }

  val powTable = Array(n) { LongArray(m + 1) }
  for (index in 0 until n) {
    powTable[index][0] = 1L
    val base = nums[index].toLong() % MOD
    for (count in 1..m) {
      powTable[index][count] = (powTable[index][count - 1] * base) % MOD
    }
  }

  val popcount = IntArray(m + 1)
  for (value in 0..m) {
    popcount[value] = Integer.bitCount(value)
  }

  fun zeros3D(): Array<Array<LongArray>> {
    return Array(m + 1) {
      Array(m + 1) {
        LongArray(k + 1)
      }
    }
  }

  var dp = zeros3D()
  dp[0][0][0] = 1L

  for (positionIndex in 0 until n) {
    val next = zeros3D()
    for (used in 0..m) {
      for (carryIn in 0..m) {
        val row = dp[used][carryIn]
        for (onesSoFar in 0..k) {
          val currentWeight = row[onesSoFar]
          if (currentWeight == 0L) continue

          val maxCanPickHere = m - used
          var chooseCount = 0
          while (chooseCount <= maxCanPickHere) {
            val sumAtBit = carryIn + chooseCount
            val bitOut = sumAtBit and 1
            val newOnes = onesSoFar + bitOut
            if (newOnes <= k) {
              val newCarry = sumAtBit ushr 1
              val newUsed = used + chooseCount

              val mult = (powTable[positionIndex][chooseCount] * invFact[chooseCount]) % MOD
              val addValue = (currentWeight * mult) % MOD

              val target = next[newUsed][newCarry]
              target[newOnes] = (target[newOnes] + addValue) % MOD
            }
            chooseCount += 1
          }
        }
      }
    }
    dp = next
  }

  var answer = 0L
  val finalUsed = m
  for (carry in 0..m) {
    val carryOnes = popcount[carry]
    val requiredOnesBeforeCarry = k - carryOnes
    if (requiredOnesBeforeCarry < 0 || requiredOnesBeforeCarry > k) continue
    val bucket = dp[finalUsed][carry][requiredOnesBeforeCarry]
    answer = (answer + bucket) % MOD
  }

  answer = (answer * fact[m]) % MOD
  return answer.toInt()
}

private fun modPow(baseInput: Long, expInput: Long): Long {
  var base = baseInput % MOD
  var exp = expInput
  var result = 1L
  var cur = base
  while (exp > 0) {
    if ((exp and 1L) == 1L) {
      result = (result * cur) % MOD
    }
    cur = (cur * cur) % MOD
    exp = exp shr 1
  }
  return result
}
