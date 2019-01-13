package com.example.day14test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.zxing.WriterException;
import com.recker.flybanner.FlyBanner;
import com.yzq.zxinglibrary.encode.CodeCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.HomeBean;
import contract.Showcontract;
import presenter.BannerPresenter;

public class MainActivity extends AppCompatActivity implements Showcontract.BannerView {
private FlyBanner flyBanner;
private BannerPresenter bannerPresenter;
private ImageView icon_sheng;
private Button Sheng_Btn,error;
private String sheng;
private EditText et_sheng;
private List<String> icon;
private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flyBanner = findViewById(R.id.flybanner);

        //生成二维码的资源id
        icon_sheng = findViewById(R.id.icon_sheng);
        Sheng_Btn = findViewById(R.id.Sheng_Btn);
       et_sheng = findViewById(R.id.et_sheng);

       error = findViewById(R.id.error);
        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=10/0;
            }
        });

        bannerPresenter = new BannerPresenter(this);

      /* List<String> list = new ArrayList<>();
       for(int i = 0;i<datas.getBanner().size();i++){
            list.add(datas.getBanner().get(i).getIcon());
       }
        flyBanner.setImagesUrl(list);*/

       if(bannerPresenter != null){
           bannerPresenter.Banner(new HashMap<String, String>());
       }


        Sheng_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheng = et_sheng.getText().toString();
                Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                try {
                    //生成二维码需要用到的类CodeCreator
                    Bitmap bitmap = CodeCreator.createQRCode(sheng, 400, 400, logo);
                    icon_sheng.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void BannerSuccess(List<HomeBean.DataBean.BannerBean> bannerbean) {
        icon = new ArrayList<>();
        for(int i=0;i<bannerbean.size();i++){
            icon.add(bannerbean.get(i).getIcon());
        }
        flyBanner.setImagesUrl(icon);
    }

    @Override
    public void BannerFailUre(String msg) {

    }
}
