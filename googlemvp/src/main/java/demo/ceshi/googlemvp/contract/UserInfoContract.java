package demo.ceshi.googlemvp.contract;

import demo.ceshi.googlemvp.model.UserInfoModel;
import demo.ceshi.googlemvp.presenter.BasePresenter;

public class UserInfoContract {


    //1.创建Persenter接口
    public interface Persenter extends BasePresenter {
        void loadUserInfo();
    }

    //2.创建View接口
    public interface View extends BaseView<Persenter> {

        void showLoading();//显示加载框

        void dimissLoading();//隐藏加载框

        void showUserInfo(UserInfoModel model);//将请求得到的数据回调

        String loadUserId();//假设请求接口需要传入用户的ID

    }
}
