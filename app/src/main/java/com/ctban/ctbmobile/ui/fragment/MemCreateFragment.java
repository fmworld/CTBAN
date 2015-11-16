package com.ctban.ctbmobile.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctban.ctblib.controller.UserController;
import com.ctban.ctbmobile.BaseCTBFragment;
import com.ctban.ctbmobile.R;
import com.ctban.ctbmobile.databinding.FragmentLoginBinding;
import com.ctban.ctbmobile.databinding.FragmentMemCreateBinding;

/**
 * 会员注册界面
 * Created by zhoufeng'an on 2015/11/16.
 */
public class MemCreateFragment extends BaseCTBFragment implements UserController.CreateUi {
    FragmentMemCreateBinding fragBinding;
    UserController.MemberCreateCallback memberCreateCallback;

    public static MemCreateFragment create() {
        MemCreateFragment fragment = new MemCreateFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_mem_create, null);
        fragBinding = DataBindingUtil.bind(fragView);

        fragBinding.create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memberCreateCallback.create(fragBinding.createName.getText().toString(),
                        fragBinding.createPassword.getText().toString());
            }
        });


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
        memberCreateCallback = (UserController.MemberCreateCallback) callbacks;
    }

    @Override
    public void userCreated(String userName, String userPwd) {
        fragBinding.create.setText("注册成功");
    }
}
