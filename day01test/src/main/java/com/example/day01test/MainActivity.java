package com.example.day01test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText et_mobile,et_password;
private Button but_login,but_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //寻找id
       et_mobile = findViewById(R.id.et_mobile);
      et_password = findViewById(R.id.et_password);
      but_login = findViewById(R.id.but_login);
     but_register = findViewById(R.id.but_register);

    final String mobile = et_mobile.getText().toString();
    final String password = et_password.getText().toString();

     //注册点击监听
        but_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        //登录点击监听
        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mobile != "" && mobile != null && password != null && password != ""){
                    //验证成功
                    Toast.makeText(MainActivity.this,"验证成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
