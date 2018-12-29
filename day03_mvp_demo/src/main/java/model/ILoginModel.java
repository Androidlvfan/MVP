package model;

import net.RequestCallback;
import java.util.HashMap;

public interface ILoginModel {
    //登录---Model接口
    //HashMap集合中存入两个String类型的参数 params
    void login(HashMap<String,String> params, RequestCallback requestCallback);//相比注册，登录要定义一个callBack来进行成功或者失败
}
