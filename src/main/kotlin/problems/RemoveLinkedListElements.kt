package problems

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
  val dummy = ListNode(0)
  dummy.next = head
  var prev: ListNode? = dummy
  while (prev!!.next != null) {
    if (prev.next!!.`val` == `val`) {
      prev.next = prev.next!!.next
    } else {
      prev = prev.next
    }
  }
  return dummy.next
}
