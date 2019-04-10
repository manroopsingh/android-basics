package com.example.user.kotlin_basicconcepts.Enums

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text


data class MediaType(val title: String, val url: String, val type: Type){
    enum class Type{PHOTO, VIDEO}
}

fun test(type: MediaType.Type) {

    when (type) {
        MediaType.Type.PHOTO -> print("photo")
        MediaType.Type.VIDEO-> print("Video")

    }

}

fun testView(view: View) {

    val stringType = when (view) {
        is TextView -> view.text = "Hello world"
        is ViewGroup -> print(view.childCount)
        else -> "unknown"
    }

    val myInt = if (view is TextView) 20 else 10


}