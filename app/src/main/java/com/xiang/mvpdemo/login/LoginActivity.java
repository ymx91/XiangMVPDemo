package com.xiang.mvpdemo.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xiang.mvpdemo.R;
import com.xiang.mvpdemo.login.presenter.impl.LoginPresenterImpl;
import com.xiang.mvpdemo.login.view.LoginView;
import com.xiang.mvpdemo.main.MainActivity;


/**
 * 登录页
 * Created by dell on 2016/9/13.
 */
public class LoginActivity extends Activity implements LoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText et_name;
    private EditText et_password;
    private Button btn_login;
    private LoginPresenterImpl loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();

        initData();


    }

    private void initData() {

        progressDialog = new ProgressDialog(LoginActivity.this);
//        progressDialog.setTitle("");
        progressDialog.setMessage("登录中");
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
//        progressDialog.show();

        loginPresenter = new LoginPresenterImpl(this);

    }

    private void bindViews() {

        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
    }


    public void login(View view){

        loginPresenter.validateCredentials(et_name.getText().toString(), et_password.getText().toString());

    }


    @Override
    public void showProgress() {

        Log.i(TAG, "展示");
        progressDialog.show();

    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void setUsernameError() {
        et_name.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        et_password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {

        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();

    }
}
