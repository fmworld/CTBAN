package com.ctban.ctbmobile.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctban.ctblib.controller.UserController;
import com.ctban.ctbmobile.BaseCTBFragment;
import com.ctban.ctbmobile.R;
import com.ctban.ctbmobile.databinding.FragmentLoginBinding;
import com.easemob.easeui.EaseConstant;

/**
 * 会员登录界面
 * Created by zhoufeng'an on 2015/11/16.
 */
public class LoginFragment extends BaseCTBFragment implements UserController.LoginUi {
    FragmentLoginBinding loginBinding;
    UserController.MemberLoginCallback userLoginCallback;

    public static LoginFragment create() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_login, null);
        loginBinding = DataBindingUtil.bind(fragView);
        loginBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginCallback.login(loginBinding.loginName.getText().toString(),
                        loginBinding.loginPassword.getText().toString());
            }
        });

        loginBinding.toCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDisplay().showMemCreatePage();
            }
        });
        loginBinding.messageList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        loginBinding.messageList.init("qqqq", EaseConstant.CHATTYPE_SINGLE,null);
        return fragView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getController().attachUi(this);
    }

    @Override
    public void onPause() {
        getController().detachUi(this);
        super.onPause();
    }

    UserController getController() {
        return getMainController().getUserController();
    }

    @Override
    public void setCallbacks(UserController.MemberUiCallback callbacks) {
        userLoginCallback = (UserController.MemberLoginCallback) callbacks;
    }


    @Override
    public void userLogined(String userName, String userPwd) {
//        getDisplay().showSingleEaseChat("qqqq");
//        getDisplay().showEaseConversationListFragment();
        getDisplay().showEaseContactListFragment();
    }
}
