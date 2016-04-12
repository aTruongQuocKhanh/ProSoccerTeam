package com.khanhtq.appcore.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by khanhtq on 4/12/16.
 */
public class RecyclerViewDivider extends RecyclerView.ItemDecoration {
    private int space;

    public RecyclerViewDivider(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = (parent.getChildPosition(view) == 0) ? 0 : space;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildPosition(view) == 0) {
            outRect.top = space * 2;
        }
    }
}
