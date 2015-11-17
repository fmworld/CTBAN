package com.ctban.ctbmobile;



import android.support.v4.app.Fragment;

import com.ctban.ctblib.Display;
import com.ctban.ctblib.controller.MainController;
import com.umeng.analytics.MobclickAgent;

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

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.getClass().getSimpleName()); //统计页面
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.getClass().getSimpleName());
    }
}
