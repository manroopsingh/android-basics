package com.example.user.kotlin_basicconcepts

import com.example.user.kotlin_basicconcepts.Sample.MediaItem

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

    for(i in 1..10) print(i)

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