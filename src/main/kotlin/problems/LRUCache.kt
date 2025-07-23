package problems

class LRUCache(private val capacity: Int) {
  // Node class for doubly linked list
  private class Node(
    val key: Int,
    var value: Int,
    var prev: Node? = null,
    var next: Node? = null
  )

  // HashMap to store key -> Node mapping for O(1) access
  private val cache = HashMap<Int, Node>()

  // Dummy head and tail nodes for easier list manipulation
  private val head = Node(0, 0)
  private val tail = Node(0, 0)

  init {
    require(capacity > 0) { "Capacity must be positive" }
    head.next = tail
    tail.prev = head
  }

  // Get value for key if it exists, otherwise return -1
  // Time complexity: O(1)
  fun get(key: Int): Int {
    return cache[key]?.let { node ->
      // Move to front (most recently used)
      removeNode(node)
      addToFront(node)
      node.value
    } ?: -1
  }

  // Put key-value pair into cache
  // Time complexity: O(1)
  fun put(key: Int, value: Int) {
    cache[key]?.let { node ->
      // Key exists, update value and move to front
      node.value = value
      removeNode(node)
      addToFront(node)
    } ?: run {
      // Key doesn't exist, add new node
      val newNode = Node(key, value)
      cache[key] = newNode
      addToFront(newNode)

      // Remove least recently used if capacity exceeded
      if (cache.size > capacity) {
        // Remove last node before tail
        tail.prev?.let { lastNode ->
          cache.remove(lastNode.key)
          removeNode(lastNode)
        }
      }
    }
  }

  // Helper function to remove node from list
  // Time complexity: O(1)
  private fun removeNode(node: Node) {
    node.prev?.next = node.next
    node.next?.prev = node.prev
  }

  // Helper function to add node to front of list (after head)
  // Time complexity: O(1)
  private fun addToFront(node: Node) {
    node.prev = head
    node.next = head.next
    head.next?.prev = node
    head.next = node
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
