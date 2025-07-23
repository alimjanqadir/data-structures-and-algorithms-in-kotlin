package datastuctures

class HashTable {
  private val table = mutableListOf("")

  init {
    repeat(100) {
      table.add("")
    }
  }


  fun put(key: String, value: String) {
    table[hash(key)] = value
  }

  fun get(key: String): String = table[hash(key)]

  private fun hash(key: String): Int {
    return (key.first().toInt() * 100 + key[1].toInt()) % 100
  }
}

