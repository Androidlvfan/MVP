package model;

import java.util.HashMap;

import api.apiUrl;
import contract.Showcontract;
import util.HttpCallBack;
import util.OkHttpUtils;

public class ShowModel implements Showcontract.ShowModel {


    @Override
    public void register(HashMap<String, String> params, final ModelCallBack modelCallBack) {
        OkHttpUtils.getmInstance().Post(apiUrl.USER_REG, params, new HttpCallBack() {
            @Override
            public void Success(String result) {
                if(modelCallBack != null){
                    modelCallBack.Success(result);
                }
            }

            @Override
            public void FailUre(String msg) {
                if(modelCallBack != null){
                    modelCallBack.FailUre(msg);
                }
            }
        });
    }

    @Override
    public void login(HashMap<String, String> params, final ModelCallBack modelCallBack) {
        OkHttpUtils.getmInstance().Post(apiUrl.USER_LOGIN, params, new HttpCallBack() {
            @Override
            public void Success(String result) {
                if(modelCallBack != null){
                    modelCallBack.Success(result);
                }
            }

            @Override
            public void FailUre(String msg) {
                if(modelCallBack != null){
                    modelCallBack.FailUre(msg);
                }
            }
        });
    }

    public interface ModelCallBack {
        void Success(String result);
        void FailUre(String msg);
    }
}
