package persenter;

import java.util.HashMap;

import contract.LoginContract;
import model.LoginModel;

public class LoginPresenter extends LoginContract.LoginPresenter {

    private LoginModel loginModel;
    private LoginContract.LoginView loginView;

    public LoginPresenter(LoginContract.LoginView loginView) {
        this.loginModel = new LoginModel();
        this.loginView = loginView;
    }

    @Override
    public void Login(HashMap<String, String> params) {
        loginModel.Login(params, new LoginModel.ModelCallBack() {
            @Override
            public void Success(String result) {
                if(loginModel != null){
                    loginView.Success(result);
                }
            }

            @Override
            public void FailUre(String msg) {
                if(loginModel != null){
                    loginView.FailUre(msg);
                }
            }
        });
    }
}
