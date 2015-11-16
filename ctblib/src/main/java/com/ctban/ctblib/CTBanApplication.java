package com.ctban.ctblib;

import android.app.Application;

import com.ctban.ctblib.controller.MainController;
import com.ctban.ctblib.models.component.DaggerMainControllerComponent;
import com.ctban.ctblib.models.component.MainControllerComponent;

import javax.inject.Inject;


/**
 * Created by zhoufeng'an on 2015/11/10.
 */
public class CTBanApplication extends Application {
    private static CTBanApplication mApplication;

    public static CTBanApplication instance() {
        return mApplication;
    }

    @Inject
    MainController mainController;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initConfig();
    }

    /**
     * 初始化应用开发堆栈
     */
    private void initConfig() {
        MainControllerComponent mainControllerComponent = DaggerMainControllerComponent.create();
        mainControllerComponent.inject(this);

        initLeakCanary();
    }


    /**
     * 集成内存优化工具leakcanary
     */
    private void initLeakCanary() {
//        if (mConfigState.isDebugModel()) {
//            LeakCanary.install(this);
//        }
    }

    public MainController getMainController() {
        return mainController;
    }
}
