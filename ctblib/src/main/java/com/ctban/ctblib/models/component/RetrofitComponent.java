package com.ctban.ctblib.models.component;

import com.ctban.ctblib.ctbretro.CTBanServer;
import com.ctban.ctblib.ctbretro.service.UserService;
import com.ctban.ctblib.models.provider.RetrofitProvider;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2015/11/10.
 */
@Component(modules ={RetrofitProvider.class})
@Singleton
public interface RetrofitComponent {
    void inject(CTBanServer ctbServer);
}
