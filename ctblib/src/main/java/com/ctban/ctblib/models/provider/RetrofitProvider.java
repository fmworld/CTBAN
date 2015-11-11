package com.ctban.ctblib.models.provider;

import com.ctban.ctblib.ctbretro.service.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2015/11/10.
 */
@Module
public class RetrofitProvider {
    final String server_url ="http://www.weather.com.cn";
    private Retrofit retrofit;
    public RetrofitProvider(){
        retrofit = new Retrofit.Builder()
                .baseUrl(server_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    @Provides
    @Singleton
    UserService provideUserService(){
        return retrofit.create(UserService.class);
    }
}
