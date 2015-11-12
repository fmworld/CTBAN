package com.ctban.ctblib.models.component;

import com.ctban.ctblib.CTBanApplication;
import com.ctban.ctblib.models.provider.MainControllerProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Component(modules = {MainControllerProvider.class})
@Singleton
public interface MainControllerComponent {
    void inject(CTBanApplication application);
}
