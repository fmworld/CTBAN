package com.ctban.ctblib.controller;


import android.util.Log;

import com.ctban.ctblib.ctbretro.bean.WeatherInfo;
import com.ctban.ctblib.models.component.DaggerStateComponent;
import com.ctban.ctblib.models.component.StateComponent;
import com.ctban.ctblib.models.provider.StateProvider;
import com.ctban.ctblib.state.UserState;
import com.ctban.ctblib.tasks.MemberLoginExcuter;

import javax.inject.Inject;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class UserController extends BaseUiController<UserController.UserUi, UserController.UserUiCallback> {
    @Inject
    UserState mUserState;

    public UserController() {
        StateComponent component = DaggerStateComponent
                .builder().stateProvider(new StateProvider()).build();
        component.inject(this);
        Log.v("dagger", "initConfig() mUserState " + mUserState);
    }

    public interface UserUiCallback {

    }

    public interface UserUi extends BaseUiController.Ui<UserUiCallback> {

    }

    public interface LoginUi extends UserUi {
        void userLogined(WeatherInfo weatherInfo);
    }

    public interface UserLoginCallback extends UserUiCallback {
        void login(String city_id);
    }

    @Override
    protected UserUiCallback createUiCallbacks(final UserUi ui) {
        if (ui instanceof LoginUi) {
            return new UserLoginCallback() {
                public void login(String city_id) {
                    new MemberLoginTask(city_id, (LoginUi) ui).excute();
                }
            };
        }
        return null;
    }

    public String getLoginUser() {
        return mUserState.getLoginUser();
    }

    private class MemberLoginTask extends MemberLoginExcuter {
        LoginUi ui;

        public MemberLoginTask(String city_id, LoginUi ui) {
            super(city_id);
            this.ui = ui;
        }

        @Override
        public void onNext(WeatherInfo weatherInfo) {
            ui.userLogined(weatherInfo);
        }

    }
}
