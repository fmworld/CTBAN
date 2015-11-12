package com.ctban.ctbmobile.models.component;

import com.ctban.ctbmobile.CTBActivity;
import com.ctban.ctbmobile.models.provider.DisplayProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
@Component(modules = {DisplayProvider.class})
@Singleton
public interface DisplayComponent {
    void inject(CTBActivity activity);
}
