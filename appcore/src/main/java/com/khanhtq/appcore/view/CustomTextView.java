package com.khanhtq.appcore.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.khanhtq.appcore.util.FontCache;

/**
 * Created by khanhtq on 4/11/16.
 */
public class CustomTextView extends TextView{

    public CustomTextView(Context context) {
        super(context);
        applyFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyFont(context);
    }

    private void applyFont(Context context) {
        Typeface customFont = FontCache.getTypeface("LucidaGrandeRegular.ttf", context);
        setTypeface(customFont);
    }
}
