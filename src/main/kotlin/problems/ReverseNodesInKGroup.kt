package problems

/**
 * Reverses nodes of the linked list in groups of k.
 * If the remaining nodes are less than k, they are left as is.
 *
 * @param head The head of the linked list
 * @param k The size of groups to reverse
 * @return The head of the modified linked list
 */
fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
  // Handle base cases
  if (head?.next == null || k == 1) return head

  // Create a dummy node to handle edge cases
  val dummy = ListNode(0)
  dummy.next = head
  var current = dummy

  while (true) {
    // Check if we have k nodes ahead
    val kthNode = findKthNode(current, k) ?: break

    // Get the next group's start node
    val nextGroupStart = kthNode.next

    // Reverse the current group
    val (newFirst, newLast) = reverseGroup(current.next!!, kthNode)

    // Connect with the previous part
    current.next = newFirst
    // Connect with the next part
    newLast.next = nextGroupStart

    // Move to the start of next group
    current = newLast
  }

  return dummy.next
}

/**
 * Finds the kth node from the given start node.
 * Returns null if there are less than k nodes ahead.
 */
private fun findKthNode(start: ListNode?, k: Int): ListNode? {
  var current = start
  repeat(k) {
    current = current?.next ?: return null
  }
  return current
}

/**
 * Reverses a group of nodes from start to end (inclusive).
 * Returns a Pair of (new first node, new last node).
 */
private fun reverseGroup(start: ListNode, end: ListNode): Pair<ListNode, ListNode> {
  var prev: ListNode? = null
  var current: ListNode? = start
  val nextGroupStart = end.next

  while (current !== nextGroupStart) {
    val next = current?.next
    current?.next = prev
    prev = current
    current = next
  }

  return Pair(end, start)
}

// Test function to create linked list from array
private fun createLinkedList(arr: IntArray): ListNode? {
  if (arr.isEmpty()) return null

  val dummy = ListNode(0)
  var current = dummy

  for (value in arr) {
    current.next = ListNode(value)
    current = current.next!!
  }

  return dummy.next
}

// Test function to convert linked list to array
private  fun linkedListToArray(head: ListNode?): IntArray {
  val result = mutableListOf<Int>()
  var current = head

  while (current != null) {
    result.add(current.`val`)
    current = current.next
  }

  return result.toIntArray()
}

