package com.example.user.kotlin_basicconcepts

import com.example.user.kotlin_basicconcepts.Sample.MediaItem


fun test(){

    val item: MediaItem? = null
    //item.print() //this would give a compiler error since the item can be null, which kotlin does not allow

    if(item!=null) item.print() //no compiler error, since kotlin knows we checked for null

    item?.print() //putting a ? would check if the value is null or not

    print(item?.print() ?: "Something")//print "Something" item is null with the ? null check

    item!!.print() //forces the compiler to disregard the null check

}