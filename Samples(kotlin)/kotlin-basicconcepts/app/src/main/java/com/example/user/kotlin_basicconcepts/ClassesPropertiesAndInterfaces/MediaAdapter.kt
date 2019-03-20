package com.example.user.kotlin_basicconcepts.ClassesPropertiesAndInterfaces

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.user.kotlin_basicconcepts.R
import com.squareup.picasso.Picasso


class MediaAdapter(private val items: List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MediaAdapter.ViewHolder {
        val inflatedView = parent.inflate(R.layout.media_item_holder)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(viewHolder: MediaAdapter.ViewHolder, position: Int) {
        viewHolder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.find<TextView>(R.id.title)
        val imageView = itemView.find<ImageView>(R.id.image)

        fun bind(item: MediaItem) {
            title.text = item.title
            imageView.loadURL(item.thumbUrl)
        }
    }

}
