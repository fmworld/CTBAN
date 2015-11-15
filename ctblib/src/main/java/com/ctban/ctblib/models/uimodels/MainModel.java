package com.ctban.ctblib.models.uimodels;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ctban.ctblib.BR;

/**
 * Created by zhoufengan on 15/11/15.
 */
public class MainModel  extends BaseObservable
{
    String city;
    String temp;

    @Bindable
    public String getCity() {
        return city;
    }

    @Bindable
    public String getTemp() {
        return temp;
    }

    public void setCity(String city) {
        this.city = city;
        this.notifyPropertyChanged(BR.city);
    }

    public void setTemp(String temp) {
        this.temp = temp;
        this.notifyPropertyChanged(BR.temp);
    }
}
