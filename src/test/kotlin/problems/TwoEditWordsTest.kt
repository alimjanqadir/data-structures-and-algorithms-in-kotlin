package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class TwoEditWordsTest {

    @Test
    fun testTwoEditWordsExample1() {
        val queries = arrayOf("word", "note", "ants", "wood")
        val dictionary = arrayOf("wood", "joke", "moat")
        val expected = listOf("word", "note", "wood")
        assertEquals(expected, twoEditWords(queries, dictionary))
    }

    @Test
    fun testTwoEditWordsExample2() {
        val queries = arrayOf("yes")
        val dictionary = arrayOf("not")
        val expected = emptyList<String>()
        assertEquals(expected, twoEditWords(queries, dictionary))
    }

    @Test
    fun testTwoEditWordsEmptyQueries() {
        val queries = emptyArray<String>()
        val dictionary = arrayOf("word", "test")
        val expected = emptyList<String>()
        assertEquals(expected, twoEditWords(queries, dictionary))
    }

    @Test
    fun testTwoEditWordsExactMatch() {
        val queries = arrayOf("word", "test")
        val dictionary = arrayOf("word", "test")
        val expected = listOf("word", "test")
        assertEquals(expected, twoEditWords(queries, dictionary))
    }

    @Test
    fun testTwoEditWordsOneDifference() {
        val queries = arrayOf("word", "ward")
        val dictionary = arrayOf("word")
        val expected = listOf("word", "ward")
        assertEquals(expected, twoEditWords(queries, dictionary))
    }

    @Test
    fun testTwoEditWordsTwoDifferences() {
        val queries = arrayOf("note")
        val dictionary = arrayOf("joke")
        val expected = listOf("note")
        assertEquals(expected, twoEditWords(queries, dictionary))
    }

    @Test
    fun testTwoEditWordsThreeDifferences() {
        val queries = arrayOf("abcd")
        val dictionary = arrayOf("wxyz")
        val expected = emptyList<String>()
        assertEquals(expected, twoEditWords(queries, dictionary))
    }

    @Test
    fun testTwoEditWordsStopsAfterFirstMatch() {
        val queries = arrayOf("word")
        val dictionary = arrayOf("wood", "ward", "word")
        val expected = listOf("word")
        assertEquals(expected, twoEditWords(queries, dictionary))
    }
}
