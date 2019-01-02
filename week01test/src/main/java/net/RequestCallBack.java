package net;

public interface RequestCallBack {
    void Success(String result);
    void Failure(String msg);
    void SuccessMsg(String msg);
}
