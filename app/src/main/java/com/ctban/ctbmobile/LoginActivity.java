package com.ctban.ctbmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.ctban.ctblib.Display;

/**
 * Created by zhoufeng'an on 2015/11/16.
 */
public class LoginActivity extends CTBMVPActivity {
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    protected void handleIntent(Intent intent, Display display) {
        getDisplay().showMemLoginPage();
    }

}
