package com.ctban.ctblib;

import android.app.Application;
import com.ctban.ctblib.models.component.DaggerStateComponent;
import com.ctban.ctblib.models.component.StateComponent;
import com.ctban.ctblib.state.ConfigState;
import com.squareup.leakcanary.LeakCanary;

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
    ConfigState mConfigState;

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

        StateComponent stateComponent = DaggerStateComponent.create();
        stateComponent.inject(this);


        initLeakCanary();
    }


    /**
     * 集成内存优化工具leakcanary
     */
    private void initLeakCanary() {
        if (mConfigState.isDebugModel()) {
            LeakCanary.install(this);
        }
    }

}
