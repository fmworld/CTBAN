package com.ctban.ctbmobile;

import android.app.Activity;

import com.ctban.ctblib.Display;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class AndroidDisplay extends Display {
    private Activity mActivity;

    public AndroidDisplay(){
    }

    public AndroidDisplay(Activity activity){
        mActivity = activity;
    }

    public void initContext(Activity activity){
        mActivity = activity;
    }
}
