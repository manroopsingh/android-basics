package com.example.singh.android_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by singh on 9/14/17.
 */

public class CustomItemTouchHelper extends ItemTouchHelper.Callback {

    CustomItemTouchHelperAdapter adapter;

    public CustomItemTouchHelper(CustomItemTouchHelperAdapter adapter) {
        this.adapter = adapter;
    }

    //returns the drag and swipe directions allowed for the Recycler View
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;

        return makeMovementFlags(dragFlags, swipeFlags);
    }

    //enables long press drag on the item
    @Override
    public boolean isLongPressDragEnabled() {
        return true;

    }

    //enables swipe 
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.onItemDismiss(viewHolder.getAdapterPosition());
    }
}
