package com.ctban.ctblib.controller;


import com.ctban.ctblib.models.component.DaggerStateComponent;
import com.ctban.ctblib.models.component.StateComponent;
import com.ctban.ctblib.state.UserState;

import javax.inject.Inject;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class UserController extends BaseUiController<UserController.UserUi, UserController.UserUiCallback> {
    @Inject
    UserState mUserState;

    public UserController(){
        StateComponent component = DaggerStateComponent
                .create();
        component.inject(this);
    }

    public interface UserUiCallback {

    }

    public interface UserUi extends BaseUiController.Ui<UserUiCallback> {

    }

    @Override
    protected UserUiCallback createUiCallbacks(UserUi ui) {
        return null;
    }

    public String getLoginUser(){
        return mUserState.getLoginUser();
    }
}
