package problems

fun isOneBitCharacter(bits: IntArray): Boolean {
  var i = 0
  while (i < bits.size - 1) {  // 不用看最后一个，因为它一定是0
    if (bits[i] == 1) {
      i += 2                // 1 开头一定是 2-bit 字符
    } else {
      i += 1                // 0 单独作为一个 1-bit 字符
    }
  }
  // 如果循环结束后 i 正好等于 n-1，说明最后一个0没有被前面吃掉
  // 如果 i == n，说明最后一个0被前面的1当成了2-bit的一部分
  return i == bits.size - 1
}
