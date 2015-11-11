package com.ctban.ctblib.models.provider;

import android.util.Log;

import com.ctban.ctblib.state.ApplicationState;
import com.ctban.ctblib.state.ConfigState;
import com.ctban.ctblib.models.component.ApplicationComponent;
import com.ctban.ctblib.models.component.DaggerApplicationComponent;
import com.ctban.ctblib.state.UserState;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Module
public class StateProvider {
    @Inject
    ApplicationState appState;
    public StateProvider(){
        ApplicationComponent stateComponent = DaggerApplicationComponent.builder()
                .applicationStateProvider(new ApplicationStateProvider()).build();
        stateComponent.inject(this);
    }

    @Provides
    @Singleton
    ConfigState provideConfigState(){
        return appState;
    }

    @Provides
    @Singleton
    UserState provideUserState(){
        return appState;
    }
}
