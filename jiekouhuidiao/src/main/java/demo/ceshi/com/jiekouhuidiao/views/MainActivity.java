package demo.ceshi.com.jiekouhuidiao.views;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import demo.ceshi.com.jiekouhuidiao.R;
import demo.ceshi.com.jiekouhuidiao.iview.IUserInterface;
import demo.ceshi.com.jiekouhuidiao.persenter.IUserPersenter;

/**
 * 接口回调实例
 */
public class MainActivity extends AppCompatActivity implements IUserInterface, SwipeRefreshLayout.OnRefreshListener {
    private IUserPersenter persenter;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout = findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(this);
        persenter = new IUserPersenter(this);//实现回调的接口
    }

    public void huiDiao(View view) {
        persenter.getData();//开始回调方法
    }

    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);
        Toast.makeText(this, "开始加载数据。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dimissLoading() {
        refreshLayout.setRefreshing(false);
        Toast.makeText(this, "数据回调成功!!!!!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addData(String name, int age, String address) {
        TextView textView = findViewById(R.id.text);
        textView.setText("姓名:" + name + "\n" +
                "年龄:" + age + "\n" +
                "住址:" + address);
    }

    @Override
    public void onRefresh() {
        persenter.getData();//开始回调方法
    }
}
