package com.ceshi.demo.presenter;

import android.os.Handler;

import com.ceshi.demo.iview.IUserInfoView;
import com.ceshi.demo.model.UserInfoModel;

public class UserInfoPresenter {

    private IUserInfoView view;//声明用户的

    public UserInfoPresenter(IUserInfoView view) {
        this.view = view;
    }

    public void loadUserInfo() {
        final String userId = view.loadUserId();//获取用户id

        view.showLoading();//现在网络加载进度提示

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟接口返回的json数据

                UserInfoModel model = new UserInfoModel("测试", 22, "山东菏泽"+userId);
                view.showUserInfo(model);//将请求的数据传给回调接口
                view.showDissmiss();//加载结束
            }
        }, 5000);
    }
}
