package com.example.user.kotlin_basicconcepts.Sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.user.kotlin_basicconcepts.R
import com.example.user.kotlin_basicconcepts.loadURL
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    //    setup a default static value for the id of the activity
    companion object {
        val ID = "DetailActivity:ID"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        gets the media item id from the incoming activity
        val id = intent.getIntExtra(ID, -1)

        MediaProvider.dataAsync { media ->//get the media list to find the item with the given id
            media.find { it.id == id }?.let { item ->//apply let of item received using lambda to set the views, with null check
                supportActionBar?.title = item.title
                detail_thumb.loadURL(item.thumbUrl)
                detail_video_indicator.visibility = when (item.type) {//use the when expression to set the video indicator to the view
                    MediaItem.Type.PHOTO -> View.GONE
                    MediaItem.Type.VIDEO -> View.VISIBLE
                }
            }
        }
    }
}
