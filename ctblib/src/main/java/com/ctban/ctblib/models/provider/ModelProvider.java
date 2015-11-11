package com.ctban.ctblib.models.provider;

import com.ctban.ctblib.models.CustomerModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
@Module
public class ModelProvider {
    @Provides @Singleton
    CustomerModel provideCustomerModel(){
        return new CustomerModel();
    }
}
