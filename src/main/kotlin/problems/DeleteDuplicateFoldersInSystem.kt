package problems

/**
 * Removes duplicate folders in a file system described by [paths].
 * Two folders are considered duplicates if they share the same non-empty
 * set of subfolders and underlying structure.
 */
private class FsNode {
  val children = sortedMapOf<String, FsNode>()
  var signatureId: Int = -1
}

fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
  val root = FsNode()

  // Build the file system trie from the paths.
  for (path in paths) {
    var current = root
    for (folder in path) {
      current = current.children.getOrPut(folder) { FsNode() }
    }
  }

  val signatureToId = mutableMapOf<List<Pair<String, Int>>, Int>()
  val idToCount = mutableMapOf<Int, Int>()
  var nextId = 0

  fun computeSignature(node: FsNode): Int {
    val childSignatures = mutableListOf<Pair<String, Int>>()
    for ((name, child) in node.children) {
      childSignatures.add(name to computeSignature(child))
    }

    val id = signatureToId.getOrPut(childSignatures) { nextId++ }
    node.signatureId = id

    if (childSignatures.isNotEmpty()) {
      idToCount[id] = idToCount.getOrDefault(id, 0) + 1
    }
    return id
  }

  computeSignature(root)

  val duplicateIds = idToCount.filter { it.value > 1 }.keys

  val result = mutableListOf<List<String>>()
  fun collectPaths(node: FsNode, currentPath: MutableList<String>) {
    if (node.signatureId in duplicateIds) return

    if (currentPath.isNotEmpty()) {
      result.add(currentPath.toList())
    }

    for ((name, child) in node.children) {
      currentPath.add(name)
      collectPaths(child, currentPath)
      currentPath.removeAt(currentPath.size - 1)
    }
  }

  collectPaths(root, mutableListOf())
  return result
}
