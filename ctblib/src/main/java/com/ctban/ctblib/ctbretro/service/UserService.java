package com.ctban.ctblib.ctbretro.service;


import com.ctban.ctblib.ctbretro.bean.WeatherInfo;
import com.ctban.ctblib.models.dao.User;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2015/11/10.
 */
public interface UserService {
    @GET("/data/sk/{city}")
    Observable<User> getUsers(@Path("city") String city_id);

    @GET("/data/sk/{city}")
    Observable<WeatherInfo> getWeather(@Path("city") String city_id);
}
