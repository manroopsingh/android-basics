package com.example.singh.android_recyclerview;

/**
 * Created by singh on 9/14/17.
 */

interface CustomItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
