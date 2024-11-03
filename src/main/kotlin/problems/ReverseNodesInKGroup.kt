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
fun createLinkedList(arr: IntArray): ListNode? {
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
fun linkedListToArray(head: ListNode?): IntArray {
    val result = mutableListOf<Int>()
    var current = head

    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }

    return result.toIntArray()
}

fun main() {

    // Test case 1
    val test1 = createLinkedList(intArrayOf(1, 2, 3, 4, 5))
    val result1 = reverseKGroup(test1, 2)
    println("Test 1: ${linkedListToArray(result1).joinToString()} should be [2, 1, 4, 3, 5]")

    // Test case 2
    val test2 = createLinkedList(intArrayOf(1, 2, 3, 4, 5))
    val result2 = reverseKGroup(test2, 3)
    println("Test 2: ${linkedListToArray(result2).joinToString()} should be [3, 2, 1, 4, 5]")

    // Test case 3 (edge case: k = 1)
    val test3 = createLinkedList(intArrayOf(1, 2, 3))
    val result3 = reverseKGroup(test3, 1)
    println("Test 3: ${linkedListToArray(result3).joinToString()} should be [1, 2, 3]")

    // Test case 4 (edge case: single node)
    val test4 = createLinkedList(intArrayOf(1))
    val result4 = reverseKGroup(test4, 2)
    println("Test 4: ${linkedListToArray(result4).joinToString()} should be [1]")
}