package com.ctban.ctblib.controller;


import android.util.Log;

import com.ctban.ctblib.models.component.DaggerStateComponent;
import com.ctban.ctblib.models.component.StateComponent;
import com.ctban.ctblib.models.provider.StateProvider;
import com.ctban.ctblib.state.UserState;
import com.easemob.EMCallBack;
import com.easemob.EMError;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;
import com.easemob.exceptions.EaseMobException;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zhoufeng'an on 2015/11/11.
 */
public class UserController extends BaseUiController<UserController.MemUi, UserController.MemberUiCallback> {
    @Inject
    UserState mUserState;

    public UserController() {
        StateComponent component = DaggerStateComponent
                .builder().stateProvider(new StateProvider()).build();
        component.inject(this);
        Log.v("dagger", "initConfig() mUserState " + mUserState);
    }

    public interface MemberUiCallback {

    }

    public interface MemUi extends BaseUiController.Ui<MemberUiCallback> {

    }

    public interface LoginUi extends MemUi {
        void userLogined(String userName, String userPwd);
    }

    public interface CreateUi extends MemUi {
        void userCreated(String userName, String userPwd);
    }

    public interface MemberLoginCallback extends MemberUiCallback {
        void login(String userName, String pwd);
    }

    public interface MemberCreateCallback extends MemberUiCallback {
        void create(String userName, String pwd);
    }

    @Override
    protected MemberUiCallback createUiCallbacks(final MemUi ui) {
        if (ui instanceof LoginUi) {
            return new MemberLoginCallback() {
                public void login(String userName, String pwd) {
                    memberLogin(userName, pwd, (LoginUi) ui);
                }
            };
        }

        if (ui instanceof CreateUi) {
            return new MemberCreateCallback() {
                public void create(String userName, String pwd) {
                    memberCreate(userName, pwd, (CreateUi) ui);
                }
            };
        }
        return null;
    }

    public String getLoginUser() {
        return mUserState.getLoginUser();
    }


    /**
     *  用户登录
     * @param userName
     * @param userPwd
     * @param ui
     */
    private void memberLogin(final String userName, final String userPwd, final LoginUi ui){
        Log.v("ctban-easymob", "userName "+userName+" userPwd "+userPwd);
        EMChatManager.getInstance().login(userName, userPwd, new EMCallBack() {
            @Override
            public void onSuccess() {
                EMGroupManager.getInstance().loadAllGroups();
                EMChatManager.getInstance().loadAllConversations();
                Observable.just(ui).subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<LoginUi>() {
                            @Override
                            public void call(LoginUi ui) {
                                ui.userLogined(userName, userPwd);
                            }
                        });

            }

            @Override
            public void onError(int i, String s) {
                Log.v("ctban-easymob", "memberLogin "+s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }

    /**
     * 会员注册
     * @param userName
     * @param userPwd
     * @param ui
     */
    private void memberCreate(final String userName, final String userPwd, final CreateUi ui){
        Observable.just("").subscribeOn(Schedulers.io())
                .map(new Func1<String, CreateUi>() {
                    @Override
                    public CreateUi call(String createUi) {
                        try {
                            EMChatManager.getInstance().createAccountOnServer(userName, userPwd);
                        } catch (final EaseMobException e) {
                            //注册失败
                            int errorCode = e.getErrorCode();
                            if (errorCode == EMError.NONETWORK_ERROR) {
                                Log.v("ctban-easymob", "网络异常，请检查网络！");
                            } else if (errorCode == EMError.USER_ALREADY_EXISTS) {
                                Log.v("ctban-easymob", "用户已存在！");
                            } else if (errorCode == EMError.UNAUTHORIZED) {
                                Log.v("ctban-easymob", "注册失败，无权限！");
                            } else {
                                Log.v("ctban-easymob", "注册失败: " + e.getMessage());
                            }
                            return null;
                        } catch (Exception e) {
                            Log.v("ctban-easymob", "e: " + e.getMessage());
                            return null;
                        }

                        return ui;
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CreateUi>() {
                    @Override
                    public void call(CreateUi createUi) {
                        createUi.userCreated(userName, userPwd);
                    }
                });
    }


}
