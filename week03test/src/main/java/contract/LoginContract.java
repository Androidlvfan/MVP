package contract;

import java.util.HashMap;

import model.LoginModel;

public interface LoginContract {
    /**
     * p
     */
   abstract class LoginPresenter{
       public abstract void Login(HashMap<String,String> params);
    }
    /**
     * m
     */
   public interface LoginModel{
        void Login(HashMap<String,String> params, final model.LoginModel.ModelCallBack modelCallBack);
    }
    /**
     * v
     */
   public interface LoginView{
        void Success(String result);
        void FailUre(String msg);
        void MobileError(String error);
    }
}
