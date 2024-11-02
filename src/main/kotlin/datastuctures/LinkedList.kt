package datastuctures

class LinkedList {

}

fun main(args: Array<String>) {
    val numbers = arrayOf(3, 5, 61, 1, 2, 5, 6, 12)
    var head: Node? = null
    var q: Node? = null

    // Create a linked list by adding numbers
    for (number in numbers) {
        val node = Node(number, null)
        if (head == null) {
            head = node
        } else {
            q?.next = node
        }
        q = node
    }

    // Read all the elements of linked list
    var t = head
    while (t != null) {
        print("${t.data} ")
        t = t.next
    }
    println()
}
