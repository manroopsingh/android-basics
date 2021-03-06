package com.example.user.kotlin_basicconcepts

import com.example.user.kotlin_basicconcepts.Sample.MediaItem

lateinit var languages: Set<String>
lateinit var votes: List<Boolean>
lateinit var countryToCapital: Map<String, String>
lateinit var testData : Array<Int>

fun main() {
    instantiateCollection()

    println(filterVotes(true))
    println(searchCountryStartsWith("F"))
    println(squareAllElements())
}

//instantiating collection in Kotlin
fun instantiateCollection() {
//    Collections
    languages = setOf("Kotlin", "Java", "C++")
    votes = listOf(true, false, false, true)
    countryToCapital = mapOf(
        "Germany" to "Berlin", "France" to "Paris"
    )
//    Arrays
    testData = arrayOf(0, 1, 5, 9, 10)

}

//filtering collections
fun filterVotes(type: Boolean): List<Boolean> = votes.filter { it == type }

//searching a collection
fun searchCountryStartsWith(startsWith: String) = countryToCapital.keys.filter {
    it.startsWith(
        startsWith
    )
}

///mapping a collection
fun squareAllElements(): Array<Int> = testData.map { it*it } as Array<Int>


/*
Experimental generic function for mapping any collection
*/
//inline fun <reified E> squareAllElements(iterable: Iterable<E>): List<E> where E : GenericNumber<E> =
//    iterable.map {
//        it.times(it)
//    }
//
//
//abstract class GenericNumber<T : Number> {
//    abstract fun times(a: T): Number
//}
//
//
//class MyInt(val int: Int) : GenericNumber<Int>() {
//
//    override fun times(b: Int): Int {
//        return int * b
//    }
//}


//filter method that returns the list of URLs that have photos
fun testFilter(items: List<MediaItem>): List<String> {
    val urlList: List<String> = items.filter { it.type == MediaItem.Type.PHOTO }
        .sortedBy { it.title }
        .map { it.thumbUrl }
    return urlList
}

//By default all lists in Kotlin are immutable, to use a mutable list use the class
//MutableList that would all us to remove and add items to the list
fun createMutableList(): List<Int> {

    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableList.add(5)
    mutableList.remove(2)


    return mutableList
}

fun testRanges() {

    for (i in 1..10) print(i)

    (1..4).forEach(::print)

    (1 until 5).forEach(::print)

    (4 downTo 1).forEach(::print)

    val x: String = "c"
    val y = when (x) {
        in "a".."f" -> 1
        in "f".."z" -> 2
        else -> 3
    }
    print(y)

}