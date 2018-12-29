package View;

import com.example.day03_mvp_demo.entity.UserEntity;

public interface ILoginView {
    void mobileError(String msg);//手机号错误
    void pwdError(String msg);//密码错误
    void failure(String msg);//请求错误
    void success(UserEntity userEntity);
    void successMsg(String msg);
}
