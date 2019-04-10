package com.example.user.kotlin_basicconcepts.Sample

/*
Data classes are used in Kotlin to hold data for an object. The typical operation on data objects
are reading, altering, comparing and copying of data.

We can use the keyword "data" prefixing the declaration of a class
*/

data class MediaItem(val title: String, val thumbUrl: String, val type: Type){
    enum class Type{PHOTO, VIDEO}
}