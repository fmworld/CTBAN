package com.ctban.ctbmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;

import com.ctban.ctblib.CTBanApplication;
import com.ctban.ctblib.Display;
import com.ctban.ctblib.controller.MainController;
import com.ctban.ctbmobile.models.component.DaggerDisplayComponent;
import com.ctban.ctbmobile.models.component.DisplayComponent;

import javax.inject.Inject;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class CTBActivity extends AppCompatActivity {
    @Inject
    AndroidDisplay mAndroidDisplay;

    MainController mainController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        initActivityConfig();
    }

    private void initActivityConfig() {
        DisplayComponent displayComponent = DaggerDisplayComponent.create();
        displayComponent.inject(this);
        mAndroidDisplay.initContext(this);
        mainController = CTBanApplication.instance().getMainController();
    }

    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent, getDisplay());
    }

    protected void handleIntent(Intent intent, Display display) {
    }

    public void showLoading() {
    }

    public void dismissLoading() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainController.attachDisplay(mAndroidDisplay);
        mainController.init();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        mainController.suspend();
        mainController.detachDisplay(mAndroidDisplay);
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAndroidDisplay = null;
    }


    public Display getDisplay() {
        return mAndroidDisplay;
    }

    public MainController getMainController(){
        return mainController;
    }
}
