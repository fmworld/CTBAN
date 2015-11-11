package com.ctban.ctblib.models.component;

import com.ctban.ctblib.models.CustomerModel;
import com.ctban.ctblib.models.provider.GreenDaoProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Component(modules = {GreenDaoProvider.class})
@Singleton
public interface GreenDaoComponent {
    void inject(CustomerModel model);
}
