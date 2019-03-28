package com.example.user.kotlin_basicconcepts.ExtensionFunctions

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

//Inflate method in the ViewGroup class for the layout inflater boiler plate code
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
//Toast on the context class
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

//For toasting on the viewholder class by reusing the Context.toast method
fun RecyclerView.ViewHolder.toast(message: String) = itemView.context.toast(message)

//Loading image using Picasso
fun ImageView.loadURL(url: String) = Picasso.get().load(url).into(this)

//use generic extension function to auto cast the view type
//by adding the keyword inline the kotlin byte code will add the function code
//within the method invocation
inline fun <reified T: View>View.find(idRes: Int): T{
    return findViewById<T>(idRes)
}

