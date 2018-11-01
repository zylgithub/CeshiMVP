package demo.ceshi.googlemvp.presenter;

import android.os.Handler;

import demo.ceshi.googlemvp.contract.UserInfoContract;
import demo.ceshi.googlemvp.model.UserInfoModel;

public class UserInfoPersenter implements UserInfoContract.Persenter {
    private UserInfoContract.View view;

    public UserInfoPersenter(UserInfoContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void loadUserInfo() {
        String userID = view.loadUserId();//获取用户的id
        view.showLoading();//开始加载
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UserInfoModel model = new UserInfoModel("回梦游仙", 100, "仙剑奇侠传");
                view.showUserInfo(model);//
                view.dimissLoading();
            }
        }, 2000);
    }

    @Override
    public void start() {
        loadUserInfo();
    }
}
