package com.ctban.ctbmobile;

import android.os.Binder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.ctban.ctblib.Display;
import com.ctban.ctbmobile.ui.fragment.LoginFragment;
import com.ctban.ctbmobile.ui.fragment.MemCreateFragment;
import com.easemob.easeui.EaseConstant;
import com.easemob.easeui.ui.EaseChatFragment;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class AndroidDisplay implements Display {
    private FragmentActivity mActivity;

    public AndroidDisplay() {
    }

    public AndroidDisplay(FragmentActivity activity) {
        mActivity = activity;
    }

    public void initContext(FragmentActivity activity) {
        mActivity = activity;
    }


    @Override
    public void showMemLoginPage() {
        Fragment fragment = LoginFragment.create();
        mActivity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_fragement, fragment, fragment.getClass().getSimpleName()).commit();
    }

    @Override
    public void showMemCreatePage() {
        Fragment fragment = MemCreateFragment.create();
        mActivity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_fragement, fragment, fragment.getClass().getSimpleName()).commit();
    }

    @Override
    public void showSingleEaseChat(String easeName) {
        EaseChatFragment fragment = new EaseChatFragment();
        Bundle data = new Bundle();
        data.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
        data.putString(EaseConstant.EXTRA_USER_ID, easeName);
        fragment.setArguments(data);

        mActivity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_fragement, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}
