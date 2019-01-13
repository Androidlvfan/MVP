package contract;

import java.util.HashMap;
import java.util.List;

import bean.HomeBean;
import model.BannerModel;
import model.ShowModel;

public interface Showcontract {

    /**
     * p
     */
    abstract class ShowPresenter{
        public abstract void register(HashMap<String,String> params);
        public abstract void login(HashMap<String,String> params);
    }
    abstract class BannerPresenter{
        public abstract void Banner(HashMap<String,String> params);
    }
    /**
     * m
     */
    interface ShowModel{
        void register(HashMap<String,String> params, model.ShowModel.ModelCallBack modelCallBack);
        void login(HashMap<String,String> params, model.ShowModel.ModelCallBack modelCallBack);
    }
    interface BannerModel{
        void Banner(HashMap<String,String> params, model.BannerModel.BannerCallBack bannerCallBack);
    }
    /**
     * v
     */
    interface ShowView{
        void Success(String result);
        void FailUre(String msg);
        void MobileError(String error);
    }
    interface BannerView{
        void BannerSuccess(List<HomeBean.DataBean.BannerBean> bannerbean);
        void BannerFailUre(String msg);
    }
}
