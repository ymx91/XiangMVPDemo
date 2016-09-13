package com.xiang.mvpdemo.main.presenter.impl;

import android.util.Log;

import com.xiang.mvpdemo.main.model.MainInterface;
import com.xiang.mvpdemo.main.model.impl.MainInterfaceImpl;
import com.xiang.mvpdemo.main.model.listener.OnFinishedListener;
import com.xiang.mvpdemo.main.presenter.MainPresenter;
import com.xiang.mvpdemo.main.view.MainView;

import java.util.List;

/**
 * Presenter Part achieved
 * Created by dell on 2016/9/13.
 */
public class MainPresenterImpl implements MainPresenter, OnFinishedListener {


    private static final String TAG = MainPresenterImpl.class.getSimpleName();

    private MainView mainView;

    private MainInterface mainInterface;

    public MainPresenterImpl(MainView mainView) {

        this.mainView = mainView;
        this.mainInterface = new MainInterfaceImpl();

    }

    @Override
    public void onResume() {

        if (mainView != null) {
            mainView.showProgress();
        }

        mainInterface.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {

        if (mainView != null) {
            mainView.showMessage(String.format("Position %d clicked", position + 1));
        }

        mainInterface.findItems(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }


    @Override
    public void onFinished(List<String> items) {


        if (items != null){

            Log.i(TAG, "items is not null");


            if (items.size() > 0){

                Log.i(TAG, "items size  > 0");
            }
        }
        if (mainView != null) {
            
            mainView.setItems(items);
            mainView.hideProgress();

            Log.i(TAG, "mainView is not null");
            
        }else{

            Log.i(TAG, "mainView is  null");
        }
            
    }

    public MainView getMainView() {
        return mainView;
    }
}