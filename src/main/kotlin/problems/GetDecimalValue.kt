package problems

/**
 * Converts a binary number stored MSB-first in a linked list to an Int.
 * Time   : O(n) – single pass, n = number of nodes
 * Space  : O(1) – only the accumulator is extra
 *
 * ⚠️  If the list can be longer than 31 bits, change `result` to Long
 *     or java.math.BigInteger to avoid overflow, because Kotlin `Int`
 *     is 32-bit signed (-2³¹ … 2³¹-1).
 */
fun getDecimalValue(head: ListNode?): Int {
  var result = 0
  var currentNode = head
  while (currentNode != null) {
    // left-shift existing bits and append the next bit
    result = (result shl 1) or currentNode.`val`
    currentNode = currentNode.next
  }
  return result
}
