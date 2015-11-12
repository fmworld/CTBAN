package com.ctban.ctbmobile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.ctban.ctblib.controller.UserController;
import com.ctban.ctblib.ctbretro.bean.WeatherInfo;
import com.ctban.ctbmobile.databinding.ActivityLoginBinding;

public class MainActivity extends CTBActivity implements UserController.LoginUi {
    UserController.UserLoginCallback mUserLoginCallback;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginCallback.login("101010100.html");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getController().attachUi(this);
    }

    @Override
    public void onPause() {
        getController().detachUi(this);
        super.onPause();
    }


    @Override
    public void userLogined(WeatherInfo weatherInfo) {
        binding.setWeather(weatherInfo.weatherinfo);
    }

    @Override
    public void setCallbacks(UserController.UserUiCallback callbacks) {
        mUserLoginCallback = (UserController.UserLoginCallback) callbacks;
    }

    UserController getController() {
        return getMainController().getUserController();
    }
}
