package com.myapplication.login;

import android.text.TextUtils;

/**
 * Created by LiuYF on 2016/12/5.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String name, String pwd, onFinishedListener listener) {
       if(TextUtils.isEmpty(name)){
           listener.onNameError();
           return;
       }else if(TextUtils.isEmpty(pwd)){
           listener.onPwdError();
           return;
       }else{
           listener.onSuccess();
       }
    }
}
