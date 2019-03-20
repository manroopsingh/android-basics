package com.example.user.kotlin_basicconcepts.ClassesPropertiesAndInterfaces

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.user.kotlin_basicconcepts.R

class MediaItem

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

        fun bind(item: MediaItem) {

        }
    }

}
