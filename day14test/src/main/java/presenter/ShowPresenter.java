package presenter;

import android.widget.Toast;

import java.util.HashMap;

import contract.Showcontract;
import model.ShowModel;
import util.ValidatorUtil;

public class ShowPresenter extends Showcontract.ShowPresenter {
private ShowModel showModel;
private Showcontract.ShowView showView;

    public ShowPresenter(Showcontract.ShowView showView) {
        this.showModel = new ShowModel();
        this.showView = showView;
    }

    @Override
    public void register(HashMap<String, String> params) {
       String phone2 = params.get("mobile");
        if(!ValidatorUtil.isMobile(phone2)){
            if(showView != null){
                showView.MobileError("手机号错误");
            }
            return;
        }
        showModel.register(params, new ShowModel.ModelCallBack() {
            @Override
            public void Success(String result) {
                if(showModel != null){
                    showView.Success(result);
                }
            }

            @Override
            public void FailUre(String msg) {
                if(showModel != null){
                    showView.FailUre(msg);
                }
            }
        });
    }

    @Override
    public void login(HashMap<String, String> params) {

        String phone = params.get("mobile");
        if(!ValidatorUtil.isMobile(phone)){
            if(showView != null){
                showView.MobileError("手机号错误");
            }
            return;
        }
        showModel.login(params, new ShowModel.ModelCallBack() {
            @Override
            public void Success(String result) {
                if(showModel != null){
                    showView.Success(result);
                }
            }

            @Override
            public void FailUre(String msg) {
                if(showModel != null){
                    showView.FailUre(msg);
                }
            }
        });
    }
}
