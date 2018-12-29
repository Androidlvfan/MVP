package presenter;

import java.util.HashMap;
import View.IRegView;
import contract.IRegContract;
import model.user.RegModel;
import util.ValidatorUtil;

public class RegPresenter extends IRegContract.RegPresenter {

    private RegModel mRegModel;//model
    private IRegContract.IRegView iRegView;//view

    public RegPresenter(IRegContract.IRegView iRegView) {
        this.mRegModel = new RegModel();
        this.iRegView = iRegView;
    }

    @Override
    public void register(HashMap<String, String> params) {

      String mobile = params.get("mobile");
      //调用正则验证手机号
      if(!ValidatorUtil.isMobile(mobile)){
          if (iRegView != null){
              iRegView.mobileError("手机号不合法");
          }
          return;
      }

      if(mRegModel != null){
          mRegModel.reg(params);
          mRegModel.setmRegCallback(new RegModel.RegCallback() {
              @Override
              public void onFailure(String msg) {
                  if(iRegView != null){
                      iRegView.failure(msg);
                  }
              }

              @Override
              public void onResponse(String result) {
                    if(iRegView != null){
                        iRegView.success(result);
                    }
              }
          });
      }

    }

    @Override
    public void login(HashMap<String, String> params) {

    }

    //销毁:可以解决内存泄漏
    public void destory(){

        if(iRegView != null){
            iRegView = null;
        }
    }
}
