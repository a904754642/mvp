package com.myapplication.login;

/**
 * Created by LiuYF on 2016/12/5.
 */

public interface LoginInteractor {
    interface onFinishedListener{
        void onNameError();
        void onPwdError();
        void onSuccess();
    }
    void login(String name,String pwd,onFinishedListener listener);
}
