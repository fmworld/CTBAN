package com.ctban.ctblib.models.provider;

import com.ctban.ctblib.CTBanApplication;
import com.ctban.ctblib.models.dao.DaoMaster;
import com.ctban.ctblib.models.dao.DaoSession;
import com.ctban.ctblib.models.dao.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
@Module
public class GreenDaoProvider {
    private static final String DB_NAME = "ctban-db";
    DaoSession mDaoSession;
    public GreenDaoProvider() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(CTBanApplication.instance(), DB_NAME, null);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        mDaoSession = daoMaster.newSession();
    }

    @Provides
    @Singleton
    UserDao provideCustomerDao() {
        return mDaoSession.getUserDao();
    }
}
