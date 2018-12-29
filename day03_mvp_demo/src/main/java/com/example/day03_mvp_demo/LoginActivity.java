package com.example.day03_mvp_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day03_mvp_demo.entity.UserEntity;

import java.io.BufferedReader;
import java.util.HashMap;
import View.ILoginView;
import presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView {
private LoginPresenter presenter;
private EditText et_mobile,et_password;
private Button but_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_mobile = findViewById(R.id.et_mobile);
        et_password = findViewById(R.id.et_password);
        but_register = findViewById(R.id.but_register);
        initData();

        //点击注册
        but_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });

    }

    //点击登录按钮
    public void login(View view){

       String mobile = et_mobile.getText().toString();
       String password = et_password.getText().toString();

        HashMap<String,String> params = new HashMap<>();
        params.put("mobile",mobile);
        params.put("password",password);

        if(presenter != null){
            presenter.login(params);
        }

    }

    private void initData() {
        presenter = new LoginPresenter(this);
    }

    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(UserEntity userEntity) {
        Toast.makeText(this,userEntity.msg+",正在跳转到主页面。。。",Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
    startActivity(intent);
    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
