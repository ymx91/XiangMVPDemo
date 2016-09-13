package com.xiang.mvpdemo.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.xiang.mvpdemo.R;
import com.xiang.mvpdemo.main.presenter.impl.MainPresenterImpl;
import com.xiang.mvpdemo.main.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, MainView {


    private ListView lv_data;
    private ProgressDialog progressDialog;
    private MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_data = (ListView) findViewById(R.id.lv_data);
        lv_data.setOnItemClickListener(this);

        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setTitle("");
        progressDialog.setMessage("加载中");
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);

        presenter = new MainPresenterImpl(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        presenter.onItemClicked(position);

    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {

        progressDialog.hide();

    }

    @Override
    public void setItems(List<String> items) {
        lv_data.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        /**
         * get data
         */
        presenter.onResume();

    }

    @Override
    protected void onDestroy() {

        presenter.onDestroy();

        super.onDestroy();
    }
}
