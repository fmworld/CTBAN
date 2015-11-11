package com.ctban.ctblib.models.provider;

import com.ctban.ctblib.ctbretro.CTBanServer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
//@Module
public class CTBanServerProvider {
//    @Provides
//    @Singleton
    CTBanServer provideServer(){
        return new CTBanServer();
    }
}
