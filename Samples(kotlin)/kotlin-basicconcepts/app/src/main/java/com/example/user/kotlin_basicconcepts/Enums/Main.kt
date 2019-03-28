package com.example.user.kotlin_basicconcepts.Enums


data class MediaType(val title: String, val url: String, val type: Type){
    enum class Type{PHOTO, VIDEO}
}

fun main() {


}