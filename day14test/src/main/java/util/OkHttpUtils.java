package util;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private Handler handler = new Handler();
    private OkHttpClient okHttpClient;
    private static OkHttpUtils mInstance;
    /**
     * 私有构造
     */
    private OkHttpUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(5,TimeUnit.SECONDS)
            .writeTimeout(5,TimeUnit.SECONDS)
            .connectTimeout(5,TimeUnit.SECONDS)
            .build();
    }
    /**
     * 实例化
     */
    public static OkHttpUtils getmInstance() {
       if (mInstance == null){
           synchronized (OkHttpUtils.class){
               if(mInstance == null){
                   mInstance = new OkHttpUtils();
               }
           }
       }
        return mInstance;
    }
    /**
     * post请求
     */
    public void Post(String url, HashMap<String,String> params, final HttpCallBack httpCallBack){
        //请求体和响应体
        FormBody.Builder formBody = new FormBody.Builder();
        for(Map.Entry<String,String> p : params.entrySet()){
            formBody.add(p.getKey(),p.getValue());
        }
        RequestBody requestBody = formBody.build();
       final Request request = new Request.Builder().url(url).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(httpCallBack != null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                          httpCallBack.FailUre("网络异常");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if(httpCallBack != null){
                   if(response.code() == 200){
                       final String result = response.body().string();
                       handler.post(new Runnable() {
                           @Override
                           public void run() {
                               httpCallBack.Success(result);
                           }
                       });
                   }
                }
            }
        });

    }
}
