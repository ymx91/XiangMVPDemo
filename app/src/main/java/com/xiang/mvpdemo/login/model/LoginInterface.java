package com.xiang.mvpdemo.login.model;


import com.xiang.mvpdemo.login.model.listener.OnLoginFinishedListener;

/**
 * Model部分，LoginInterface
 */
public interface LoginInterface {

    void login(String username, String password, OnLoginFinishedListener listener);

}
