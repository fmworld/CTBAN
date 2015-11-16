package com.ctban.ctbmobile;



import android.support.v4.app.Fragment;

import com.ctban.ctblib.Display;
import com.ctban.ctblib.controller.MainController;

/**
 * Created by zhoufeng'an on 2015/11/16.
 */
public class BaseCTBFragment extends Fragment {
    protected MainController getMainController() {
        return ((CTBMVPActivity) (this.getActivity())).getMainController();
    }

    public Display getDisplay() {
        return ((CTBMVPActivity) (this.getActivity())).getDisplay();
    }
}
