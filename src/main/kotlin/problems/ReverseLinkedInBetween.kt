package problems

import datastuctures.Node

fun reverseBetween(head: Node?, left: Int, right: Int): Node? {
    // Handle edge cases
    if (head?.next == null || left == right) {
        return head
    }

    // Create dummy node to handle cases where left = 1
    val dummy = Node(0).apply { next = head }
    var prev = dummy

    // Move to the node just before the reversal starts
    repeat(left - 1) {
        prev = prev.next!!
    }

    // Start reversing from this node
    var current = prev.next
    var nextNode: Node? = null

    // Reverse the sublist
    repeat(right - left + 1) {
        val temp = current?.next
        current?.next = nextNode
        nextNode = current
        current = temp
    }

    // Connect the reversed portion back to the list
    prev.next?.next = current  // Connect end of reversed portion to rest of list
    prev.next = nextNode      // Connect previous part to start of reversed portion

    return dummy.next
}

fun reverseBetweenUsingMoveToFront(head: Node?, left: Int, right: Int): Node? {
    // Handle edge cases
    if (head?.next == null || left == right) return head

    // Create a dummy node to handle edge case when left = 1
    val dummy = Node(0).apply { next = head }
    var prev = dummy

    // Move to the node just before the reversal should start
    repeat(left - 1) {
        prev = prev.next!!
    }

    // Start reverse process
    val start = prev.next // This is the node where reversal begins
    var current = start?.next

    // Reverse the sublist
    repeat(right - left) {
        start?.next = current?.next
        current?.next = prev.next
        prev.next = current
        current = start?.next
    }

    return dummy.next
}

fun reverseBetweenFunctional(head: Node?, left: Int, right: Int): Node? {
    // Convert linked list to sequence for easier functional operations
    val nodeSequence = generateSequence(head) { it.next }
        .withIndex()
        .toList()

    if (nodeSequence.isEmpty() || left == right) return head

    // Split the list into three parts: before, during, and after reversal
    val beforeReverse = nodeSequence.take(left - 1)
    val toReverse = nodeSequence.drop(left - 1).take(right - left + 1)
    val afterReverse = nodeSequence.drop(right)

    // Combine the parts, with the middle part reversed
    return (beforeReverse + toReverse.reversed() + afterReverse)
        .map { it.value.value }
        .toLinkedList()
}

/**
 * Creates a new linked list from the given values using fold.
 */
private fun List<Int>.toLinkedList(): Node? =
    this.foldRight(null as Node?) { value: Int, acc ->
        Node(value, acc)
    }


// Extension function to convert linked list to list for testing
fun Node?.toList(): List<Int> {
    val result = mutableListOf<Int>()
    var current = this

    while (current != null) {
        result.add(current.value)
        current = current.next
    }

    return result
}

// Test cases
fun main() {
    // Test case 1: [1,2,3,4,5], left = 2, right = 4
    val test1 = listOf(1, 2, 3, 4, 5).toLinkedList()
    println("Test 1: ${reverseBetween(test1, 2, 4)?.toList()}")
    // Expected output: [1,4,3,2,5]

    // Test case 2: [5], left = 1, right = 1
    val test2 = listOf(5).toLinkedList()
    println("Test 2: ${reverseBetween(test2, 1, 1)?.toList()}")
    // Expected output: [5]

    // Additional test case 3: [1,2,3,4,5], left = 1, right = 5 (reverse entire list)
    val test3 = listOf(1, 2, 3, 4, 5).toLinkedList()
    println("Test 3: ${reverseBetween(test3, 1, 5)?.toList()}")
    // Expected output: [5,4,3,2,1]
}