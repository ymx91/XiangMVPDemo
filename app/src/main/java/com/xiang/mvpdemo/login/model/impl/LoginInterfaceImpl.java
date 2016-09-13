package com.xiang.mvpdemo.login.model.impl;

import android.os.Handler;
import android.text.TextUtils;

import com.xiang.mvpdemo.login.model.LoginInterface;
import com.xiang.mvpdemo.login.model.listener.OnLoginFinishedListener;

/**
 * Model部分，实现LoginInterface
 * Created by dell on 2016/9/13.
 */
public class LoginInterfaceImpl implements LoginInterface {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {

            @Override public void run() {

                boolean error = false;

                if (TextUtils.isEmpty(username)){

                    listener.onUsernameError();
                    error = true;

                }

                if (TextUtils.isEmpty(password)){

                    listener.onPasswordError();
                    error = true;
                }

                if (!error){
                    listener.onSuccess();
                }
            }

        }, 2000);

    }
}
