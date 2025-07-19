package problems

fun removeSubfolders(folder: Array<String>): List<String> {
  folder.sort()
  val keptFolders = ArrayList<String>()
  var lastKept: String? = null

  for (path in folder) {
    val prefix = if (lastKept == null) null else "$lastKept/"
    if (lastKept == null || !path.startsWith(prefix!!)) {
      keptFolders.add(path)
      lastKept = path
    }
  }
  return keptFolders
}

