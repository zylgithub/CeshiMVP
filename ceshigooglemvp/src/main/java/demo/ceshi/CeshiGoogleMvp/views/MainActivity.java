package demo.ceshi.CeshiGoogleMvp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import demo.ceshi.CeshiGoogleMvp.R;
import demo.ceshi.CeshiGoogleMvp.contract.UserInfoContract;
import demo.ceshi.CeshiGoogleMvp.model.UserModel;
import demo.ceshi.CeshiGoogleMvp.persenter.UserPersenter;

public class MainActivity extends AppCompatActivity implements UserInfoContract.View {

    private UserInfoContract.Persenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new UserPersenter(this);
    }

    public void startMVP(View view) {
        persenter.start();
    }

    @Override
    public String userId() {
        return "userId";
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "开始加载", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        Toast.makeText(this, "加载结束", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UserInfoCallback(UserModel model) {
        Toast.makeText(this, model.getName() + "\n" + model.getAge() + "\n" + model.getAddress(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPersenter(UserInfoContract.Persenter persenter) {
        this.persenter = persenter;
    }
}
