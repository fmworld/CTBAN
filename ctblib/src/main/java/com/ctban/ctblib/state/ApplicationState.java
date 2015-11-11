package com.ctban.ctblib.state;

import com.ctban.ctblib.models.CustomerModel;
import com.ctban.ctblib.models.component.DaggerModelComponent;
import com.ctban.ctblib.models.component.ModelComponent;

import javax.inject.Inject;

/**
 * Created by zhoufeng'an on 2015/11/10.
 */
public class ApplicationState implements ConfigState, UserState{
    @Inject
    CustomerModel mCustomerModel;

    public ApplicationState(){
        ModelComponent component = DaggerModelComponent.create();
        component.inject(this);
    }

    private boolean isDebugModel = true;

    public boolean isDebugModel() {
        return isDebugModel;
    }

    @Override
    public String getLoginUser() {
        return mCustomerModel.getLoginUser();
    }
}
