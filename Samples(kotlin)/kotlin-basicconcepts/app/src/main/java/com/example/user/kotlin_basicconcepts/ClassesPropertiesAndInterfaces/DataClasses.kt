package com.example.user.kotlin_basicconcepts.ClassesPropertiesAndInterfaces

/*
Data classes are used in Kotlin to hold data for an object. The typical operation on data objects
are reading, altering, comparing and copying of data.

We can use the keyword "data" prefixing the declaration of a class
*/

data class MediaItem(val title: String, val thumbUrl: String)

//Example
fun main() {

//    Generated Items
    val media1 = MediaItem("Title", "ThumbUrl")
    val media2 = MediaItem("Title", "ThumbUrl")
    val media3 = MediaItem("Title", "ThumbUrl2")

//toString
    println(media1) //MediaItem(title=Title, thumbUrl=ThumbUrl)

//equals
    println(media1 === media2) //true
    println(media1 == media3) //false

//hashCode
    val items = hashSetOf(media1, media2, media3)
    println(items.size) //2 ( no duplicates in sets)

//componentN
    val (title, thumbUrl) = media1
    println("$title's URL address is $thumbUrl") //Title's URL address is ThumbUrl

//copy
    val mediaCopy = media1.copy(title = "CopiedTitle")
    println(mediaCopy)

}



