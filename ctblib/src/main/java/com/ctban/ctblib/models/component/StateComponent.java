package com.ctban.ctblib.models.component;

import android.app.Application;

import com.ctban.ctblib.CTBanApplication;
import com.ctban.ctblib.controller.UserController;
import com.ctban.ctblib.state.ApplicationState;
import com.ctban.ctblib.models.provider.StateProvider;
import com.ctban.ctblib.state.ConfigState;
import com.ctban.ctblib.state.UserState;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Component(modules = {StateProvider.class})
@Singleton
public interface StateComponent {
    void inject(CTBanApplication application);
    void inject(UserController userController);
}
