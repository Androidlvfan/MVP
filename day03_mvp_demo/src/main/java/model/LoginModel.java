package model;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.example.day03_mvp_demo.entity.UserEntity;
import com.google.gson.Gson;
import net.RequestCallback;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import api.UserApi;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements ILoginModel {

   Handler handler = new Handler();

   //继承Model接口，实现接口中的所有方法
    @Override
    public void login(HashMap<String, String> params,final RequestCallback callback) {

        //OkHttp网络框架的管理类
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();

        //对请求体
        FormBody.Builder formBody = new FormBody.Builder();
        for(Map.Entry<String,String> p : params.entrySet()){
            formBody.add(p.getKey(),p.getValue());
        }
        //创建请求信息对象
        //请求接口UserApi & 使用post请求方式安全访问
        final Request request = new Request.Builder().url(UserApi.USER_LOGIN).post(formBody.build()).build();

        //创建请求执行对象
        Call call = okHttpClient.newCall(request);//调用OKhttp中的newCall的请求方法（newCall是一个请求方法）

        //enqueue异步请求----实现接口----
        call.enqueue(new Callback() {

            //失败
            @Override
            public void onFailure(Call call, IOException e) {
                if(callback != null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络不好！");
                        }
                    });
                }
            }
            //成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();//响应体是String类型
                int code = response.code();//相应状态码
                //TextUtils.isEmpty判断字符串是否为null或者空字符串
                //判断result不是空
                if(!TextUtils.isEmpty(result)){
                    //不为空直接进行调用json解析方法---传参：result,callback,code。
                    paserResult(result,callback,code);
                }
            }
        });
    }
    //解析gson数据变成对象
    private void paserResult(String result,final RequestCallback callback,final int code){

       final UserEntity userEntity = new Gson().fromJson(result,UserEntity.class);

       if(callback != null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                   if( code == 200){
                       callback.success(userEntity);
                   }else{
                     callback.successMsg(userEntity.msg);
                   }
                }
            });
        }
    }
}
