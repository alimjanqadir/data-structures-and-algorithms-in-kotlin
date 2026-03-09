package problems

/**
 * 3129. Find All Possible Stable Binary Arrays I
 *
 * You are given 3 positive integers zero, one, and limit.
 * A binary array arr is called stable if:
 * - The number of occurrences of 0 in arr is exactly zero.
 * - The number of occurrences of 1 in arr is exactly one.
 * - Each subarray of arr with a size greater than limit must contain both 0 and 1.
 *
 * Return the total number of stable binary arrays. Since the answer may be very large,
 * return it modulo 10^9 + 7.
 */
fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
    
  val MOD = 1_000_000_007
    
  val dpZero = Array(zero + 1) { LongArray(one + 1) }
  val dpOne = Array(zero + 1) { LongArray(one + 1) }
    
  // Base cases: arrays with only zeros or only ones within limit
  for (zerosUsed in 1..minOf(limit, zero)) {
    dpZero[zerosUsed][0] = 1
  }
    
  for (onesUsed in 1..minOf(limit, one)) {
    dpOne[0][onesUsed] = 1
  }
    
  // Fill DP table
  for (zerosUsed in 0..zero) {
    for (onesUsed in 0..one) {
            
      // Skip base cases that are already initialized
      if (zerosUsed == 0 && onesUsed == 0) continue
      if (zerosUsed > 0 && onesUsed == 0) continue
      if (zerosUsed == 0 && onesUsed > 0) continue
            
      // Calculate dpZero[zerosUsed][onesUsed]
      // We can end with a block of zeros of length k (1 <= k <= limit)
      for (k in 1..minOf(limit, zerosUsed)) {
        dpZero[zerosUsed][onesUsed] = 
          (dpZero[zerosUsed][onesUsed] + dpOne[zerosUsed - k][onesUsed]) % MOD
      }
            
      // Calculate dpOne[zerosUsed][onesUsed]
      // We can end with a block of ones of length k (1 <= k <= limit)
      for (k in 1..minOf(limit, onesUsed)) {
        dpOne[zerosUsed][onesUsed] = 
          (dpOne[zerosUsed][onesUsed] + dpZero[zerosUsed][onesUsed - k]) % MOD
      }
            
    }
  }
    
  return ((dpZero[zero][one] + dpOne[zero][one]) % MOD).toInt()
}
