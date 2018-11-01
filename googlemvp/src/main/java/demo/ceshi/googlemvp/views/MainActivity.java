package demo.ceshi.googlemvp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import demo.ceshi.googlemvp.R;
import demo.ceshi.googlemvp.contract.UserInfoContract;
import demo.ceshi.googlemvp.model.UserInfoModel;
import demo.ceshi.googlemvp.presenter.UserInfoPersenter;

/**
 * 谷歌官方MVP设计模式
 */
public class MainActivity extends AppCompatActivity implements UserInfoContract.View {

    private UserInfoContract.Persenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new UserInfoPersenter(this);

    }

    public void start(View view) {
        persenter.start();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "开始加载", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dimissLoading() {
        Toast.makeText(this, "加载完成。。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserInfo(UserInfoModel model) {
        Log.d("MainActivity", model.toString());
    }

    @Override
    public String loadUserId() {
        return "0000";
    }

    @Override
    public void setPresenter(UserInfoContract.Persenter presenter) {
        this.persenter = presenter;
    }
}
