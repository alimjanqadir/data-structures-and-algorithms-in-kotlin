package problems

fun rotateRight(head: ListNode?, k: Int): ListNode? {
  if (head == null || head.next == null || k == 0) {
    return head
  }

  var length = 1
  var tail = head
  while (tail?.next != null) {
    tail = tail.next
    length += 1
  }

  tail?.next = head

  val effectiveRotation = k % length
  if (effectiveRotation == 0) {
    tail?.next = null
    return head
  }

  val stepsToNewTail = length - effectiveRotation
  var newTail = head
  for (step in 1 until stepsToNewTail) {
    newTail = newTail?.next
  }

  val newHead = newTail?.next
  newTail?.next = null

  return newHead
}
