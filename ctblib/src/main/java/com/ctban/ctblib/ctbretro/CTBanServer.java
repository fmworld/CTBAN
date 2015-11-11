package com.ctban.ctblib.ctbretro;

import com.ctban.ctblib.ctbretro.service.UserService;
import com.ctban.ctblib.models.component.DaggerRetrofitComponent;
import com.ctban.ctblib.models.component.RetrofitComponent;
import com.ctban.ctblib.models.provider.RetrofitProvider;

import javax.inject.Inject;


/**
 * Created by Administrator on 2015/11/10.
 */
public class CTBanServer {
    public static CTBanServer mCTBanServer;
    public static CTBanServer instance(){
        return null == mCTBanServer ? new CTBanServer():mCTBanServer;
    }
    @Inject
    UserService mUserService;

    public CTBanServer() {
        RetrofitComponent retrofitComponent = DaggerRetrofitComponent.builder()
                .retrofitProvider(new RetrofitProvider()).build();
        retrofitComponent.inject(this);
    }

    public UserService getUserService() {
        return mUserService;
    }
}
