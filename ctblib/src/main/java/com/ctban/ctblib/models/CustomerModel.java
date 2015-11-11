package com.ctban.ctblib.models;

import com.ctban.ctblib.models.component.DaggerGreenDaoComponent;
import com.ctban.ctblib.models.component.GreenDaoComponent;
import com.ctban.ctblib.models.dao.UserDao;

import javax.inject.Inject;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class CustomerModel {
    @Inject
    UserDao mUserDao;

    public CustomerModel(){
        GreenDaoComponent component = DaggerGreenDaoComponent.create();
        component.inject(this);
    }

    public String getLoginUser() {
        return "hello world";
    }
}
