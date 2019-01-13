package com.example.day14test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

import bean.RegBean;
import contract.Showcontract;
import presenter.ShowPresenter;

public class RegActivity extends AppCompatActivity implements Showcontract.ShowView {
private Button reg;
private EditText et_phone2,et_pwd2;
private ShowPresenter showPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        reg = findViewById(R.id.reg);
        et_phone2 = findViewById(R.id.et_phone2);
        et_pwd2 = findViewById(R.id.et_pwd2);

        showPresenter = new ShowPresenter(this);

        //点击注册
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入框内容
                String et_phone = et_phone2.getText().toString();
                String et_pwd = et_pwd2.getText().toString();
                HashMap<String,String> params = new HashMap<>();
                params.put("mobile",et_phone);
                params.put("password",et_pwd);
                Toast.makeText(RegActivity.this,params+"",Toast.LENGTH_SHORT).show();

                if(showPresenter != null){
                    showPresenter.register(params);
                }
            }
        });
    }

    public void go_login(View view) {
        Intent intent = new Intent(RegActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void Success(String result) {
        RegBean regBean = new Gson().fromJson(result, RegBean.class);
        Toast.makeText(RegActivity.this,regBean.getMsg(),Toast.LENGTH_SHORT).show();
        if(regBean.getMsg().equals("注册成功")){
            Toast.makeText(RegActivity.this,regBean.getMsg(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void FailUre(String msg) {
        Toast.makeText(RegActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void MobileError(String error) {
        Toast.makeText(RegActivity.this,error,Toast.LENGTH_SHORT).show();
    }
}
