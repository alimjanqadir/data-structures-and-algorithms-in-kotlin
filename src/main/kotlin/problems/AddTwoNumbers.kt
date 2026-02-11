package problems

/**
 * Solution for adding two numbers represented as linked lists
 * Time Complexity: O(max(N, M)) where N and M are lengths of input lists
 * Space Complexity: O(max(N, M)) for the result list
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
  // Create a dummy head node for the result list
  val dummyHead = ListNode(0)
  var current = dummyHead

  var p1 = l1 // Pointer for first list
  var p2 = l2 // Pointer for second list
  var carry = 0 // Carry value for addition

  // Continue while we have digits to process or carry exists
  while (p1 != null || p2 != null || carry > 0) {
    // Get values from lists or 0 if list ended
    val x = p1?.`val` ?: 0
    val y = p2?.`val` ?: 0

    // Calculate sum and new carry
    val sum = x + y + carry
    carry = sum / 10

    // Create new node with current digit
    current.next = ListNode(sum % 10)
    current = current.next!!

    // Move pointers if possible
    p1 = p1?.next
    p2 = p2?.next
  }

  return dummyHead.next
}

/**
 * Test cases to verify the solution
 */
