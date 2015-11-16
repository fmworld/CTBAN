package com.ctban.ctblib.models.uimodels;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ctban.ctblib.BR;

/**
 * Created by zhoufengan on 15/11/15.
 */
public class MemberModel extends BaseObservable
{
    String userName;
    String password;

    @Bindable
    public String getUserName() {
        return userName;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
