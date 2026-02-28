package problems

fun concatenatedBinary(n: Int): Int {
  val MOD = 1_000_000_007
  var result: Long = 0
  var length = 0

  for (i in 1..n) {
    // Discovery 4: If 'i' is a power of 2, the bit length increases by 1
    if ((i and (i - 1)) == 0) {
      length++
    }
        
    // Discovery 2 & 3: Shift the previous result to make room, add 'i', and modulo
    // Note: We use 'or' instead of '+' because shifting creates trailing zeros, 
    // making bitwise OR functionally identical to addition, but slightly faster.
    result = ((result shl length) or i.toLong()) % MOD
  }
    
  // The final answer easily fits back into an Int because of the modulo
  return result.toInt()
}
