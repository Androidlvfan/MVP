package model;

import java.util.concurrent.TimeUnit;
import contract.ShowContract;
import okhttp3.OkHttpClient;

public class ShowModel implements ShowContract.ShowModel {

    @Override
    public void Success(String result) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();

    }

    @Override
    public void Failure(String msg) {

    }
}
