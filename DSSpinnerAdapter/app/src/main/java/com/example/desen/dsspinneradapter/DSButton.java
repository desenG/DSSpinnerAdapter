package com.example.desen.dsspinneradapter;

import android.content.Context;
import android.widget.Button;

/**
 * Created by desen on 2016-10-28.
 */

public class DSButton extends Button {

    public DSButton(Context context) {
        super(context);
    }

    public OnClickListener mOnClickListener;

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
        mOnClickListener = l;
    }
    public OnClickListener getmOnClickListener() {
        return mOnClickListener;
    }
}
