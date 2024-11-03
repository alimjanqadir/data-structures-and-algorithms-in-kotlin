package problems

fun rotateRight(head: ListNode?, k: Int): ListNode? {
  // Handle edge cases
  if (head?.next == null || k == 0) return head

  // Step 1: Calculate length and find the last node
  var length = 1
  var tail = head
  while (tail?.next != null) {
    length++
    tail = tail.next
  }

  // Step 2: Calculate effective rotation amount
  val effectiveK = k % length
  if (effectiveK == 0) return head

  // Step 3: Find the new tail position (length - effectiveK - 1)
  var newTail = head
  repeat(length - effectiveK - 1) {
    newTail = newTail?.next
  }

  // Step 4: Perform rotation
  val newHead = newTail?.next
  newTail?.next = null
  tail?.next = head

  return newHead
}

// Extension function to create linked list from list for testing
private fun List<Int>.toLinkedList(): ListNode? {
  if (isEmpty()) return null

  val head = ListNode(first())
  var current = head

  for (value in drop(1)) {
    current.next = ListNode(value)
    current = current.next!!
  }

  return head
}

// Extension function to convert linked list to list for testing
fun ListNode?.toList(): List<Int> {
  val result = mutableListOf<Int>()
  var current = this

  while (current != null) {
    result.add(current.`val`)
    current = current.next
  }

  return result
}

// Test cases
fun main() {
  // Test case 1: [1,2,3,4,5], k = 2
  val test1 = listOf(1, 2, 3, 4, 5).toLinkedList()
  println("Test 1: ${rotateRight(test1, 2)?.toList()} == [4,5,1,2,3]")

  // Test case 2: [0,1,2], k = 4
  val test2 = listOf(0, 1, 2).toLinkedList()
  println("Test 2: ${rotateRight(test2, 4)?.toList()} == [2,0,1]")

  // Test case 3: Empty list
  val test3 = listOf<Int>().toLinkedList()
  println("Test 3: ${rotateRight(test3, 1)?.toList()} == []")

  // Test case 4: Single node
  val test4 = listOf(1).toLinkedList()
  println("Test 4: ${rotateRight(test4, 1)?.toList()} == [1]")

  // Test case 5: k = 0
  val test5 = listOf(1, 2, 3).toLinkedList()
  println("Test 5: ${rotateRight(test5, 0)?.toList()} == [1,2,3]")
}