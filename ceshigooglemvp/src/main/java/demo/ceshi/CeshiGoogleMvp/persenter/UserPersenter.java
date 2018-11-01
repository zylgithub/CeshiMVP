package demo.ceshi.CeshiGoogleMvp.persenter;

import android.os.Handler;

import demo.ceshi.CeshiGoogleMvp.contract.UserInfoContract;
import demo.ceshi.CeshiGoogleMvp.model.UserModel;

/**
 * 创建用户的persenter
 */
public class UserPersenter implements UserInfoContract.Persenter {
    private UserInfoContract.View view;

    public UserPersenter(UserInfoContract.View view) {
        this.view = view;
        view.setPersenter(this);
    }

    @Override
    public void loadUserInfo() {
        String userId = view.userId();//获取用户的id
        view.showLoading();//开始加载
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UserModel model = new UserModel("Android", 10, "安迪·鲁宾");
                view.UserInfoCallback(model);
                view.dismissLoading();
            }
        }, 3000);
    }

    @Override
    public void start() {
        loadUserInfo();//调用加载数据的方法
    }
}
