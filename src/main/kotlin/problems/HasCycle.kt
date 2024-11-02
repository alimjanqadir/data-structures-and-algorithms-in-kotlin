package problems

private fun hasCycleWithHashSet(head: ListNode?): Boolean {
  // Handle empty list
  if (head == null) return false

  // Use Kotlin's mutable set
  val visited = mutableSetOf<ListNode>()

  var current = head
  while (current != null) {
    // If we've seen this node before, we found a cycle
    if (!visited.add(current)) return true
    current = current.next
  }

  return false
}

private fun hasCycle(head: ListNode?): Boolean {
  // Handle empty or single node lists
  if (head?.next == null) return false

  // Initialize two pointers
  var tortoise = head
  var hare = head.next

  // Move tortoise one step and hare two steps
  while (hare != null) {
    // If hare reaches end, no cycle exists
    if (hare.next == null) return false

    // If pointers meet, we found a cycle
    if (tortoise == hare) return true

    // Move pointers
    tortoise = tortoise?.next
    hare = hare.next?.next
  }

  return false
}

private fun hasCycleFunctional(head: ListNode?): Boolean =
  generateSequence(Pair(head, head?.next)) { (slow, fast) ->
    fast?.next?.let { Pair(slow?.next, it.next) }
  }.takeWhile { (slow, fast) ->
    fast != null && slow != fast
  }.lastOrNull()
    ?.second != null

fun main() {
  // Test case 1: Cycle present
  val node1 = ListNode(3)
  val node2 = ListNode(2)
  val node3 = ListNode(0)
  val node4 = ListNode(-4)
  node1.next = node2
  node2.next = node3
  node3.next = node4
  node4.next = node2  // Create cycle

  println("Test 1 (Cycle): ${hasCycle(node1)}")  // Should print true

  // Test case 2: No cycle
  val list2 = ListNode(1).apply {
    next = ListNode(2).apply {
      next = ListNode(3)
    }
  }

  println("Test 2 (No Cycle): ${hasCycle(list2)}")  // Should print false
}