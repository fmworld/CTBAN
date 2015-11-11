package com.ctban.ctblib.models.provider;

import com.ctban.ctblib.state.ApplicationState;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Module
public class ApplicationStateProvider {
    @Provides
    @Singleton
    ApplicationState provideApplicationState(){
        return new ApplicationState();
    }
}
