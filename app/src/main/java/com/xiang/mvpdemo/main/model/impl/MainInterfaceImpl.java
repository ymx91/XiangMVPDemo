package com.xiang.mvpdemo.main.model.impl;

import android.os.Handler;

import com.xiang.mvpdemo.main.model.MainInterface;
import com.xiang.mvpdemo.main.model.listener.OnFinishedListener;

import java.util.Arrays;
import java.util.List;

/**
 * Model Part achieved
 * Created by dell on 2016/9/13.
 */
public class MainInterfaceImpl implements MainInterface {

    @Override
    public void findItems(final OnFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                List<String> data = Arrays.asList(

                        "Item 1",
                        "Item 2",
                        "Item 3",
                        "Item 4",
                        "Item 5",
                        "Item 6",
                        "Item 7",
                        "Item 8",
                        "Item 9",
                        "Item 10"
                );

                listener.onFinished(data);

            }
        }, 2000);


    }


}
