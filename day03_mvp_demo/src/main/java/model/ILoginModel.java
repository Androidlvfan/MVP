package model;

import net.RequestCallback;

import java.util.HashMap;

public interface ILoginModel {
    //登录---Model接口
    //HashMap集合中存入两个String类型的参数 params
    void login(HashMap<String,String> params, RequestCallback requestCallback);
}
