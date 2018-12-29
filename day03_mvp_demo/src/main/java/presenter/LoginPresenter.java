package presenter;

import com.example.day03_mvp_demo.entity.UserEntity;

import net.RequestCallback;

import java.util.HashMap;

import View.ILoginView;
import model.LoginModel;
import util.ValidatorUtil;

public class LoginPresenter {

    private LoginModel loginModel;//Model
    private ILoginView iLoginView;//View

    public LoginPresenter(ILoginView iLoginView) {
        loginModel = new LoginModel();
        this.iLoginView = iLoginView;
    }

    public void login (HashMap<String,String> params){

        String mobile = params.get("mobile");//动态获取

     //正则验证
     if(!ValidatorUtil.isMobile(mobile)){
            if(iLoginView != null){
                iLoginView.mobileError("请输入手机号");
            }
            return;
     }

     //调用model
        if(loginModel != null){
           loginModel.login(params, new RequestCallback() {
               @Override
               public void failure(String msg) {
                   if(iLoginView != null){
                       iLoginView.failure(msg);
                   }
               }

               @Override
               public void success(UserEntity userEntity) {
                    if(iLoginView != null){
                        iLoginView.success(userEntity);
                    }
               }

               @Override
               public void successMsg(String msg) {
                    if(iLoginView != null){
                        iLoginView.successMsg(msg);
                    }
               }
           });
        }
    }
}
