package com.ctban.ctblib.models.component;

import com.ctban.ctblib.models.CustomerModel;
import com.ctban.ctblib.models.provider.GreenDaoProvider;
import com.ctban.ctblib.models.provider.ModelProvider;
import com.ctban.ctblib.state.ApplicationState;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Component(modules = {ModelProvider.class})
@Singleton
public interface ModelComponent {
    void inject(ApplicationState state);
}
