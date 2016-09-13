package com.xiang.mvpdemo.login.presenter;

/**
 * Presenter部分，LoginPresenter
 * Created by dell on 2016/9/13.
 */
public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();

}
