package com.ceshi.demo.iview;

import com.ceshi.demo.model.UserInfoModel;

public interface IUserInfoView {

    String loadUserId();//接口请求需要一个用户id

    void showLoading();//开始加载的方法

    void showDissmiss();//加载完成的方法

    void showUserInfo(UserInfoModel model);//将网络请求得到的用户数据信息回调



}
