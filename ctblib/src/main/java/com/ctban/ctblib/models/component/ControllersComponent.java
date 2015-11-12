package com.ctban.ctblib.models.component;

import com.ctban.ctblib.CTBanApplication;
import com.ctban.ctblib.controller.MainController;
import com.ctban.ctblib.models.provider.ControllersProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Component(modules = {ControllersProvider.class})
@Singleton
public interface ControllersComponent {
//    void inject(CTBanApplication application);
    void inject(MainController mainController);
}
