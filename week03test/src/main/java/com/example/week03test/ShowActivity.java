package com.example.week03test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;
import com.yzq.zxinglibrary.encode.CodeCreator;

import java.security.CodeSource;

public class ShowActivity extends AppCompatActivity {
private EditText et_Zxing;
private Button but_Zxing,error;
private ImageView iv_Zxing;
private int i;
private String sheng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //资源id
       et_Zxing = findViewById(R.id.et_Zxing);
       iv_Zxing = findViewById(R.id.iv_Zxing);
       but_Zxing = findViewById(R.id.but_Zxing);
       error = findViewById(R.id.error);

       //生成二维码
       but_Zxing.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              sheng = et_Zxing.getText().toString();
               Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
               try {
                   Bitmap bitmap1 = CodeCreator.createQRCode(sheng, 400, 400, bitmap);
                   iv_Zxing.setImageBitmap(bitmap1);
               } catch (WriterException e) {
                   e.printStackTrace();
               }
           }
       });

       //异常捕获机制
       error.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               i = 10/0;
           }
       });
    }
}
