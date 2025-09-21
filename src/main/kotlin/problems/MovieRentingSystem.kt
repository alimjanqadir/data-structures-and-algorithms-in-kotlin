package problems

import java.util.TreeSet

private data class ShopEntry(
  val price: Int,
  val shop: Int
) : Comparable<ShopEntry> {
  override fun compareTo(other: ShopEntry): Int {
    if (price != other.price) return price - other.price
    return shop - other.shop
  }
}

private data class RentedEntry(
  val price: Int,
  val shop: Int,
  val movie: Int
) : Comparable<RentedEntry> {
  override fun compareTo(other: RentedEntry): Int {
    if (price != other.price) return price - other.price
    if (shop != other.shop) return shop - other.shop
    return movie - other.movie
  }
}

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {

  // (shop, movie) -> price
  private val priceByCopy = HashMap<Pair<Int, Int>, Int>(entries.size * 2)

  // movie -> available shops ordered by (price, shop)
  private val availableByMovie = HashMap<Int, TreeSet<ShopEntry>>()

  // all rented copies ordered by (price, shop, movie)
  private val rentedSet = TreeSet<RentedEntry>()

  init {
    for (record in entries) {
      val shop = record[0]
      val movie = record[1]
      val price = record[2]
      priceByCopy[shop to movie] = price
      val setForMovie = availableByMovie.getOrPut(movie) { TreeSet() }
      setForMovie.add(ShopEntry(price, shop))
    }
  }

  fun search(movie: Int): List<Int> {
    val result = ArrayList<Int>(5)
    val setForMovie = availableByMovie[movie] ?: return result
    val iterator = setForMovie.iterator()
    var pickedCount = 0
    while (iterator.hasNext() && pickedCount < 5) {
      val entry = iterator.next()
      result.add(entry.shop)
      pickedCount += 1
    }
    return result
  }

  fun rent(shop: Int, movie: Int) {
    val price = priceByCopy[shop to movie] ?: return
    // Remove from available pool for the movie
    availableByMovie[movie]?.remove(ShopEntry(price, shop))
    // Add into rented set
    rentedSet.add(RentedEntry(price, shop, movie))
  }

  fun drop(shop: Int, movie: Int) {
    val price = priceByCopy[shop to movie] ?: return
    // Remove from rented set
    rentedSet.remove(RentedEntry(price, shop, movie))
    // Add back to available
    val setForMovie = availableByMovie.getOrPut(movie) { TreeSet() }
    setForMovie.add(ShopEntry(price, shop))
  }

  fun report(): List<List<Int>> {
    val result = ArrayList<List<Int>>(5)
    val iterator = rentedSet.iterator()
    var pickedCount = 0
    while (iterator.hasNext() && pickedCount < 5) {
      val entry = iterator.next()
      result.add(listOf(entry.shop, entry.movie))
      pickedCount += 1
    }
    return result
  }
}
