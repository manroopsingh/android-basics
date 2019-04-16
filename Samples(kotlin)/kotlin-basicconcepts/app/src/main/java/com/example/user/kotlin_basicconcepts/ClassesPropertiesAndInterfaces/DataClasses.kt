package com.example.user.kotlin_basicconcepts.ClassesPropertiesAndInterfaces

import com.example.user.kotlin_basicconcepts.Sample.MediaItem




//Example
fun main() {

//    Generated Items
    val media1 = MediaItem(1,
        "Title",
        "ThumbUrl",
        MediaItem.Type.PHOTO
    )
    val media2 = MediaItem(1,
        "Title",
        "ThumbUrl",
        MediaItem.Type.PHOTO
    )
    val media3 = MediaItem(3,
        "Title",
        "ThumbUrl2",
        MediaItem.Type.PHOTO
    )

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



