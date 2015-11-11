package com.ctban.ctblib.models.component;

import com.ctban.ctblib.models.provider.StateProvider;
import com.ctban.ctblib.state.ApplicationState;
import com.ctban.ctblib.models.provider.ApplicationStateProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Component(modules = {ApplicationStateProvider.class})
@Singleton
public interface ApplicationComponent {
    void inject(StateProvider stateProvider);
}
