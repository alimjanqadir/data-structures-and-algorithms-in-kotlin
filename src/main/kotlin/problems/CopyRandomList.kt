package problems

import datastuctures.Node

// Solution 1: Using HashMap
fun copyRandomListHashMap(head: Node?): Node? {
  if (head == null) return null

  // Step 1: Create map of old nodes to new nodes
  val nodeMap = HashMap<Node, Node>()
  var current = head

  // First pass: Create new nodes
  while (current != null) {
    nodeMap[current] = Node(current.`val`)
    current = current.next
  }

  // Second pass: Connect pointers
  current = head
  while (current != null) {
    nodeMap[current]?.next = nodeMap[current.next]
    nodeMap[current]?.random = nodeMap[current.random]
    current = current.next
  }

  return nodeMap[head]
}

// Solution 2: Space-Optimized Interleaved Approach
fun copyRandomList(head: Node?): Node? {
  if (head == null) return null

  // Step 1: Create interleaved list
  var current = head
  while (current != null) {
    val copy = Node(current.`val`)
    copy.next = current.next
    current.next = copy
    current = copy.next
  }

  // Step 2: Set random pointers for copied nodes
  current = head
  while (current != null) {
    current.next?.random = current.random?.next
    current = current.next?.next
  }

  // Step 3: Separate the lists
  val dummy = Node(0)
  var copyTail = dummy
  current = head

  while (current != null) {
    val copy = current.next
    val next = copy?.next

    copyTail.next = copy
    copyTail = copy!!

    current.next = next
    current = next
  }

  return dummy.next
}

// Test function
// Helper function to print list
private fun printList(head: Node?) {
  var current = head
  while (current != null) {
    print("[${current.`val`},")
    print("${current.random?.`val` ?: "null"}] → ")
    current = current.next
  }
  println("null")
}

