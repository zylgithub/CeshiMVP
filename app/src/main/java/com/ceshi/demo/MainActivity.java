package com.ceshi.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ceshi.demo.iview.IUserInfoView;
import com.ceshi.demo.model.UserInfoModel;
import com.ceshi.demo.presenter.UserInfoPresenter;

public class MainActivity extends AppCompatActivity implements IUserInfoView {


    private UserInfoPresenter presenter;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new UserInfoPresenter(this);

    }

    public void click(View view) {
        userId = "00000000000000000000000000000";

        presenter.loadUserInfo();//开始请求数据
    }

    @Override
    public String loadUserId() {
        Log.d("MainActivity", "--loadUserId--" + userId);
        return userId;//传入请求的参数
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "开始请求数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDissmiss() {
        Toast.makeText(this, "请求数据结束", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserInfo(UserInfoModel model) {
        Log.d("MainActivity", "--获取请求的数据--" + model.getName() + "\t" + model.getAge() + "\t" + model.getAddress());
    }


}
