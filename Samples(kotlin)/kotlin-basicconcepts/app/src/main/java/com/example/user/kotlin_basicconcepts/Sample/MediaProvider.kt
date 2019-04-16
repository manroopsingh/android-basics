package com.example.user.kotlin_basicconcepts.Sample

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

object MediaProvider {

    private val thumbBase = "http://lorempixel.com/400/400/"

    //Using ranges to create the media items
//    val data = (1..10).map {
//        MediaItem(
//            it,
//            "Title $it",
//            "$thumbBase$it",
//            if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
//        )
//    }

    var data = emptyList<MediaItem>()

    fun dataAsync(callback: (List<MediaItem>) -> Unit) {

        doAsync {
            data = (1..10).map {
                MediaItem(
                    it,
                    "Title $it",
                    "$thumbBase$it",
                    if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
                )
            }
            uiThread {
                callback(data)
            }
        }

    }

    fun dataSync(type: String): List<MediaItem> {
        return (1..10).map {
            MediaItem(
                it,
                "Title $it",
                "$thumbBase$type/$it",
                if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
            )
        }
    }
}