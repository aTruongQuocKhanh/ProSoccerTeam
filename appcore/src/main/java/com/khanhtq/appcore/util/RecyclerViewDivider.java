package com.khanhtq.appcore.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by khanhtq on 4/12/16.
 */
public class RecyclerViewDivider extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int space;
    private int mOrientation;

    public RecyclerViewDivider(int space, int orientation) {
        this.space = space;
        mOrientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = (parent.getChildPosition(view) == 0) ? 0 : space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0) {
                outRect.top = space * 2;
            }
        } else {
            outRect.top = space;
            outRect.bottom = space;
            outRect.right = (parent.getChildPosition(view) == 0) ? 0 : space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0) {
                outRect.left = space * 2;
            }
        }
    }
}
