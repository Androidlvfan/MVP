package com.example.day04test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private LinearLayout layout;
private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        myView = findViewById(R.id.myview);
        for (int i = 0; i < 10; i++) {
            TextView tv = new TextView(this);
            tv.setText(i+"");
            layout.addView(tv);
        }
        myView.invalidate();
        myView.postInvalidate();
    }
}
