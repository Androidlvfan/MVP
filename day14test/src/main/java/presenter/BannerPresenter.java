package presenter;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import bean.HomeBean;
import contract.Showcontract;
import model.BannerModel;

public class BannerPresenter extends Showcontract.BannerPresenter {

    private BannerModel bannerModel;
    private Showcontract.BannerView bannerView;

    public BannerPresenter( Showcontract.BannerView bannerView) {
        this.bannerModel = new BannerModel();
        this.bannerView = bannerView;
    }

    @Override
    public void Banner(HashMap<String, String> params) {
        bannerModel.Banner(params, new BannerModel.BannerCallBack() {
            @Override
            public void success(String result) {
                //gson解析
            HomeBean homeBean = new Gson().fromJson(result, HomeBean.class);
            List<HomeBean.DataBean.BannerBean> bannerBean = homeBean.getData().getBanner();
                bannerView.BannerSuccess(bannerBean);
        }

            @Override
            public void failUre(String msg) {
                if(bannerModel != null){
                    bannerView.BannerFailUre(msg);
                }
            }
        });
    }
}
