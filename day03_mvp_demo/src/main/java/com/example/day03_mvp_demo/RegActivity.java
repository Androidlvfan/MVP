package com.example.day03_mvp_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;
import contract.IRegContract;
import presenter.RegPresenter;

public class RegActivity extends AppCompatActivity implements IRegContract.IRegView {
private RegPresenter regPresenter;
private EditText et_mobile2,et_password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
       et_mobile2 = findViewById(R.id.et_mobile2);
      et_password2 = findViewById(R.id.et_password2);
        initData();

    }

    private void initData() {
        regPresenter = new RegPresenter(this);//this当前类的对象实例
    }

    //点击注册按钮
    public void regBtn(View view) {

       String mobile2 = et_mobile2.getText().toString();
       String password2 = et_password2.getText().toString();

        HashMap<String,String> params = new HashMap<>();
        params.put("mobile",mobile2);
        params.put("password",password2);
        regPresenter.register(params);

    }
    @Override
    public void mobileError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(regPresenter != null){
            regPresenter.destory();
        }
    }


}
