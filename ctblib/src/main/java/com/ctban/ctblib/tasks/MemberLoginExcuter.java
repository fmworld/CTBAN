package com.ctban.ctblib.tasks;

import com.ctban.ctblib.ctbretro.CTBanServer;
import com.ctban.ctblib.ctbretro.bean.WeatherInfo;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhoufeng'an on 2015/11/12.
 */
public class MemberLoginExcuter extends RxJavaNetExcuter<WeatherInfo> {
    Observable<WeatherInfo> weatherInfoObservable;

    public MemberLoginExcuter(String city_id){
        weatherInfoObservable = CTBanServer.instance().getUserService().getWeather(city_id);
    }

    @Override
    public void onNext(WeatherInfo weatherInfo) {

    }

    @Override
    public void excute() {
        weatherInfoObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }
}
