package com.ctban.ctbmobile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.ctban.ctblib.controller.UserController;
import com.ctban.ctblib.ctbretro.bean.WeatherInfo;
import com.ctban.ctbmobile.databinding.ActivityLoginBinding;
import com.ctban.ctbmobile.databinding.ActivityMainBinding;
import com.ctban.ctbmobile.ui.adapter.TestRecyclerAdapter;

public class MainActivity extends CTBActivity implements UserController.LoginUi {
    UserController.UserLoginCallback mUserLoginCallback;
    ActivityLoginBinding loginTop;
    ActivityMainBinding testContent;
    TestRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginTop = DataBindingUtil.setContentView(this, R.layout.activity_login);
        testContent = DataBindingUtil.bind(View.inflate(this, R.layout.activity_main, null));
        loginTop.getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginCallback.login("101010100.html");
            }
        });
        loginTop.layoutParent.addView(testContent.getRoot());

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        loginTop.listRecycler.setLayoutManager(manager);

        adapter = new TestRecyclerAdapter();

        loginTop.listRecycler.setAdapter(adapter);
        loginTop.refreshLayout.setLoadMore(true);
        loginTop.refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loginTop.refreshLayout.finishRefresh();
            }

            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout){
                loginTop.refreshLayout.finishRefreshLoadMore();
            };
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
        loginTop.setWeather(weatherInfo.weatherinfo);
        testContent.setWeather(weatherInfo.weatherinfo);
    }

    @Override
    public void setCallbacks(UserController.UserUiCallback callbacks) {
        mUserLoginCallback = (UserController.UserLoginCallback) callbacks;
    }

    UserController getController() {
        return getMainController().getUserController();
    }
}
