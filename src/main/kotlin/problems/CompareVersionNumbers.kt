package problems

fun compareVersion(version1: String, version2: String): Int {
  var index1 = 0
  var index2 = 0
  val length1 = version1.length
  val length2 = version2.length

  while (index1 < length1 || index2 < length2) {
    var part1 = 0
    while (index1 < length1 && version1[index1] != '.') {
      part1 = part1 * 10 + (version1[index1] - '0')
      index1 += 1
    }
    if (index1 < length1 && version1[index1] == '.') index1 += 1

    var part2 = 0
    while (index2 < length2 && version2[index2] != '.') {
      part2 = part2 * 10 + (version2[index2] - '0')
      index2 += 1
    }
    if (index2 < length2 && version2[index2] == '.') index2 += 1

    if (part1 < part2) return -1
    if (part1 > part2) return 1
  }
  return 0
}
