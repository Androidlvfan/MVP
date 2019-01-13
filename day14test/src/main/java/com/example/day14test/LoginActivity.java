package com.example.day14test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

import bean.LoginBean;
import contract.Showcontract;
import presenter.ShowPresenter;

public class LoginActivity extends AppCompatActivity implements Showcontract.ShowView {
private EditText et_phone;
private EditText et_pwd;
private ShowPresenter showPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //寻找id
       et_phone = findViewById(R.id.et_phone);
       et_pwd = findViewById(R.id.et_pwd);

       showPresenter = new ShowPresenter(this);
    }

    public void login(View view) {
        //获取数据
        String login_phone = et_phone.getText().toString();
        String login_pwd  = et_pwd.getText().toString();
        HashMap<String,String> params = new HashMap<>();
        params.put("mobile",login_phone);
        params.put("password",login_pwd);
        Toast.makeText(LoginActivity.this,params+"",Toast.LENGTH_SHORT).show();

        if(showPresenter != null){
            showPresenter.login(params);
        }
    }

    public void reg(View view) {
        Intent intent = new Intent(LoginActivity.this,RegActivity.class);
        startActivity(intent);
    }

    @Override
    public void Success(String result) {

        LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
        Toast.makeText(LoginActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();

        if(loginBean.getMsg().equals("登录成功")){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void FailUre(String msg) {
        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void MobileError(String error) {
        Toast.makeText(LoginActivity.this,error,Toast.LENGTH_SHORT).show();
    }
}
