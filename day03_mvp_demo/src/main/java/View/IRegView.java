package View;

public interface IRegView {

    void mobileError(String error);//网络错误
    void success(String result);//请求成功
    void failure(String msg);//请求失败
}
