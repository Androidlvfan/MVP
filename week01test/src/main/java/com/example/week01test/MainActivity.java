package com.example.week01test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import Adapter.ShowAdapter;
import contract.ShowContract;

public class MainActivity extends AppCompatActivity implements ShowContract.ShowView {
private GridView gv;
private ShowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       gv = findViewById(R.id.gv);
       adapter = new ShowAdapter(this);
       gv.setAdapter(adapter);
    }

    @Override
    public void Success(String result) {

    }

    @Override
    public void Failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SuccessMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FailKey(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SuccessKey(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
