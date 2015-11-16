package com.ctban.ctbmobile;

import com.ctban.ctblib.CTBanApplication;
import com.easemob.easeui.controller.EaseUI;

/**
 * Created by zhoufeng'an on 2015/11/16.
 */
public class CTBanMApplication extends CTBanApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initEasyChat();
    }

    private void initEasyChat(){
        EaseUI.getInstance().init(this);
    }
}
