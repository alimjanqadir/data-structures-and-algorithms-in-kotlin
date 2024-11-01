package problems

/**
 * Solution for adding two numbers represented as linked lists
 * Time Complexity: O(max(N, M)) where N and M are lengths of input lists
 * Space Complexity: O(max(N, M)) for the result list
 */
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
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
private fun main() {
    // Test Case 1: Regular case
    val test1L1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }
    val test1L2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    // Test Case 2: Different lengths
    val test2L1 = ListNode(9).apply {
        next = ListNode(9)
    }
    val test2L2 = ListNode(1)

    // Helper function to print list
    fun printList(node: ListNode?) {
        var current = node
        while (current != null) {
            print("${current.`val`} ")
            current = current.next
        }
        println()
    }

    println("Test Case 1:")
    printList(addTwoNumbers(test1L1, test1L2)) // Expected: 7 0 8

    println("Test Case 2:")
    printList(addTwoNumbers(test2L1, test2L2)) // Expected: 0 0 1
}

