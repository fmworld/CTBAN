package com.ctban.ctbmobile.models.provider;

import com.ctban.ctbmobile.AndroidDisplay;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
@Module
public class DisplayProvider {

    @Provides
    @Singleton
    AndroidDisplay provideAndroidDisplay(){
        return new AndroidDisplay();
    }
}
