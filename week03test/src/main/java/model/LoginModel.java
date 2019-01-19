package model;

import net.HttpCallBack;
import net.OkHttpUtils;

import java.util.HashMap;

import api.ApiUrl;
import contract.LoginContract;

public class LoginModel implements LoginContract.LoginModel {

    @Override
    public void Login(HashMap<String, String> params, final ModelCallBack modelCallBack) {
        OkHttpUtils.getmInstance().Post(ApiUrl.USER_LOGIN, params, new HttpCallBack() {
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

    public interface ModelCallBack{
        void Success(String result);
        void FailUre(String msg);
    }
}
