package com.ctban.ctblib.controller;


import com.ctban.ctblib.Display;
import com.ctban.ctblib.models.component.ControllersComponent;
import com.ctban.ctblib.models.component.DaggerControllersComponent;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class MainController extends BaseUiController<MainController.MainUi, MainController.MainUiCallback> {
//    @Inject
//    ConfigState mConfigState;

    @Inject
    UserController mUserController;

    public MainController() {
        ControllersComponent cComponent = DaggerControllersComponent.create();
        cComponent.inject(this);
    }

    public interface MainUiCallback {

    }

    public interface MainUi extends BaseUiController.Ui<MainUiCallback> {

    }

    public void attachDisplay(Display display) {
        Preconditions.checkNotNull(display, "display is null");
        Preconditions.checkState(getDisplay() == null, "we currently have a display");
        setDisplay(display);
    }

    public void detachDisplay(Display display) {
        Preconditions.checkNotNull(display, "display is null");
        Preconditions.checkState(getDisplay() == display, "display is not attached");
        setDisplay(null);
        mUserController.setDisplay(null);
    }

    @Override
    protected void setDisplay(Display display) {
        super.setDisplay(display);
        mUserController.setDisplay(display);
    }

    @Override
    protected void onSuspended() {
        mUserController.suspend();
        super.onSuspended();
    }

    @Override
    protected void onInited() {
        super.onInited();
        mUserController.init();
    }


    @Override
    protected MainUiCallback createUiCallbacks(final MainUi ui) {

        return null;
    }

    public UserController getUserController() {
        return mUserController;
    }
}
