package com.example.user.kotlin_basicconcepts.Sample

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.user.kotlin_basicconcepts.R
import com.example.user.kotlin_basicconcepts.inflate
import com.example.user.kotlin_basicconcepts.loadURL
import kotlinx.android.synthetic.main.media_item_holder.view.*
import kotlin.properties.Delegates

//used for more readable names for complex lambdas
typealias Listener = (MediaItem)-> Unit

class MediaAdapter(items: List<MediaItem>, val listener: Listener): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

//    Since we are using lambdas, we dont need to create the onclick interface like we do in Java
//    interface OnMediaClickListener{
//        fun onClick(mediaItem: MediaItem)
//    }

    var items: List<MediaItem> by Delegates.observable(items){ _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.media_item_holder)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = items[position]
        viewHolder.bind(item)
        viewHolder.itemView.setOnClickListener { listener.invoke(item)}
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        Using kotlin extension we dont have to find views by calling the find method anymore
//        If your view is complex the recommended way to cache the views is by calling findViewById
//        in the ViewHolder class

//        val title = itemView.find<TextView>(R.id.title)
//        val imageView = itemView.find<ImageView>(R.id.image)
//        val videoIndicator = itemView.find<ImageView>(R.id.media_video_indicator)

        //using with we can remove the duplicate calls to the object for property access
        fun bind(item: MediaItem) = with(itemView){
                title.text = item.title
                image.loadURL(item.thumbUrl)
                media_video_indicator?.visibility = when (item.type) {
                    MediaItem.Type.VIDEO -> View.VISIBLE
                    MediaItem.Type.PHOTO -> View.GONE
                }
            }

    }

}
