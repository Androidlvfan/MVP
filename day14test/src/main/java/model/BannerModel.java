package model;

import java.util.HashMap;

import api.apiUrl;
import contract.Showcontract;
import util.HttpCallBack;
import util.OkHttpUtils;

public class BannerModel implements Showcontract.BannerModel {

    @Override
    public void Banner(HashMap<String, String> params, final BannerCallBack bannerCallBack) {
        OkHttpUtils.getmInstance().Post(apiUrl.USER_HOME, params, new HttpCallBack() {
            @Override
            public void Success(String result) {
                if(bannerCallBack != null){
                    bannerCallBack.success(result);
                }
            }

            @Override
            public void FailUre(String msg) {
                if(bannerCallBack != null){
                    bannerCallBack.failUre(msg);
                }
            }
        });
    }

    public interface BannerCallBack{
        void success(String result);
        void failUre(String msg);
    }
}
