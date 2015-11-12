package com.ctban.ctblib.models.component;


import com.ctban.ctblib.controller.MainController;
import com.ctban.ctblib.controller.UserController;
import com.ctban.ctblib.models.provider.StateProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Component(modules = {StateProvider.class})
@Singleton
public interface StateComponent {
    void inject(UserController userController);
//    void inject(MainController mainController);
}
