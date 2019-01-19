package com.example.week03test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

import bean.LoginBean;
import contract.LoginContract;
import persenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginContract.LoginView {
private EditText et_phone,et_pwd;
private Button but_login;
private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       et_phone = findViewById(R.id.et_phone);
       et_pwd = findViewById(R.id.et_pwd);
       but_login = findViewById(R.id.but_login);

loginPresenter = new LoginPresenter(this);
       //登录点击监听
       but_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String phone = et_phone.getText().toString();
               String pwd = et_pwd.getText().toString();
               HashMap<String,String> params = new HashMap<>();
               params.put("mobile",phone);
               params.put("password",pwd);
               Toast.makeText(MainActivity.this,params+"",Toast.LENGTH_SHORT).show();
               if(loginPresenter != null){
                   loginPresenter.Login(params);
               }
           }
       });
    }

    @Override
    public void Success(String result) {
        LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
        Toast.makeText(MainActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,ShowActivity.class);
        startActivity(intent);
    }

    @Override
    public void FailUre(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void MobileError(String error) {
        Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
    }
}
