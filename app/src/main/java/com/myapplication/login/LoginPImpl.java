package com.myapplication.login;

/**
 * Created by LiuYF on 2016/12/5.
 */

public class LoginPImpl implements LoginP, LoginInteractor.onFinishedListener {
    private LoginV v;
    private LoginInteractor interactor;

    public LoginPImpl(LoginV v) {
        this.v = v;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void checkLogin(String name, String pwd) {
        interactor.login(name, pwd, this);
    }

    @Override
    public void onDestory() {
        v = null;
    }

    @Override
    public void onNameError() {
        if (v != null)
            v.setNameError();
    }

    @Override
    public void onPwdError() {
        if (v != null)
            v.setPwdError();
    }

    @Override
    public void onSuccess() {
        if (v != null)
            v.successToHome();
    }
}
