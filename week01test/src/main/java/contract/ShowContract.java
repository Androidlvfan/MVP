package contract;

public interface ShowContract {
   //model层
    public interface ShowModel {
      void Success(String result);
      void Failure(String msg);
    }
    //presenter层
    public interface ShowPresenter{
        void Success(String result);
        void Failure(String msg);
        void SuccessMsg(String msg);
    }
    //view层
    public interface ShowView{
        void Success(String result);
        void Failure(String msg);
        void SuccessMsg(String msg);
        void FailKey(String msg);
        void SuccessKey(String msg);
    }
}
