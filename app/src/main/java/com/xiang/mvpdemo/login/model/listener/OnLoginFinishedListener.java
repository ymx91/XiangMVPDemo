package com.xiang.mvpdemo.login.model.listener;

/**
 * Created by dell on 2016/9/13.
 */
public interface OnLoginFinishedListener {

    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
