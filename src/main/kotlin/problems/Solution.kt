package problems

// Trie node class for efficient word storage and search
private class TrieNode {
  val children = Array<TrieNode?>(26) { null }
  var word: String? = null
}

// Build Trie from words list
private fun buildTrie(words: Array<String>): TrieNode {
  val root = TrieNode()
  for (word in words) {
    var node = root
    for (char in word) {
      val index = char - 'a'
      if (node.children[index] == null) {
        node.children[index] = TrieNode()
      }
      node = node.children[index]!!
    }
    node.word = word
  }
  return root
}

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
  val result = mutableListOf<String>()
  val root = buildTrie(words)

  // Search from each cell in the board
  for (i in board.indices) {
    for (j in board[0].indices) {
      dfs(board, i, j, root, result)
    }
  }

  return result
}

private fun dfs(
  board: Array<CharArray>,
  row: Int,
  col: Int,
  node: TrieNode,
  result: MutableList<String>
) {
  // Check boundaries and if cell is already visited
  if (row !in board.indices || col !in board[0].indices ||
    board[row][col] == '#'
  ) return

  val char = board[row][col]
  val nextNode = node.children[char - 'a'] ?: return

  // If we found a word, add it to result
  nextNode.word?.let {
    result.add(it)
    nextNode.word = null  // Mark as found to avoid duplicates
  }

  // Mark current cell as visited
  board[row][col] = '#'

  // Search in all four directions
  val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
  for ((dx, dy) in directions) {
    dfs(board, row + dx, col + dy, nextNode, result)
  }

  // Restore the cell
  board[row][col] = char
}

// Test cases
