package com.xiang.mvpdemo.main.view;

import java.util.List;

/**
 * View Part
 * Created by dell on 2016/9/13.
 */
public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}
