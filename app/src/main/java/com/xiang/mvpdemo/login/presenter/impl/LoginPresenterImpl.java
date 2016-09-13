package com.xiang.mvpdemo.login.presenter.impl;

import com.xiang.mvpdemo.login.model.LoginInterface;
import com.xiang.mvpdemo.login.model.impl.LoginInterfaceImpl;
import com.xiang.mvpdemo.login.model.listener.OnLoginFinishedListener;
import com.xiang.mvpdemo.login.presenter.LoginPresenter;
import com.xiang.mvpdemo.login.view.LoginView;

/**
 *  Presenter部分，实现LoginPresenter，管理View和Model
 * Created by dell on 2016/9/13.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInterface loginInterface;


    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.loginInterface = new LoginInterfaceImpl();

    }


    @Override
    public void validateCredentials(String username, String password) {

        if (loginView != null) {
            loginView.showProgress();
        }

        loginInterface.login(username, password, this);
    }


    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {

        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {

        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onSuccess() {

        if (loginView != null) {
            loginView.navigateToHome();
            loginView.hideProgress();
        }
    }
}
