package demo.ceshi.CeshiGoogleMvp.contract;

import demo.ceshi.CeshiGoogleMvp.model.UserModel;
import demo.ceshi.CeshiGoogleMvp.persenter.BasePersenter;

//View 和Persenter分离
public class UserInfoContract {

    //1.创建Persenter
    public interface Persenter extends BasePersenter {
        void loadUserInfo();
    }

    //2.创建View数据监听
    public interface View extends BaseView<Persenter> {
        String userId();//获取用户id（请求接口时需要传入的参数）

        void showLoading();//显示加载框

        void dismissLoading();//数据加载完成进度框消失

        void UserInfoCallback(UserModel model);//将接口返回的数据，回调给页面
    }
}
