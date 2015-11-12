package com.ctban.ctbmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class CTBActivity extends AppCompatActivity {
    AndroidDisplay mAndroidDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        initActivityConfig();
    }

    private void initActivityConfig() {
        initActivityConfig();
        mAndroidDisplay =  new AndroidDisplay(this);
    }
}
