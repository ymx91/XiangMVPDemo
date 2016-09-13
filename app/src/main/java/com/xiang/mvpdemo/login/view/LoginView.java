package com.xiang.mvpdemo.login.view;

/**
 *  View部分
 * Created by dell on 2016/9/13.
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
