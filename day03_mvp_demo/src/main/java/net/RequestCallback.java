package net;

import com.example.day03_mvp_demo.entity.UserEntity;
//这个接口是在登录model的gson解析的方法中分别实现的
public interface RequestCallback {
    //网络请求失败
    void failure(String msg);
    //数据和网络请求成功
    void success(UserEntity userEntity);
    //网络请求成功，但是输入的用户名或密码不正确
    void successMsg(String msg);

}
