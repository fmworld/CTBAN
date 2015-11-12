package com.ctban.ctblib.models.provider;

import com.ctban.ctblib.controller.UserController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhoufeng'an on 2015/11/12.
 */
@Module
public class ControllersProvider {
    @Provides
    @Singleton
    UserController provideUserController(){
        return new UserController();
    }
}
