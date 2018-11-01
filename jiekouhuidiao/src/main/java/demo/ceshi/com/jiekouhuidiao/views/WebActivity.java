package demo.ceshi.com.jiekouhuidiao.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import demo.ceshi.com.jiekouhuidiao.R;
import demo.ceshi.com.jiekouhuidiao.iview.WebPagerInterFace;
import demo.ceshi.com.jiekouhuidiao.persenter.WebPersenter;

/**
 * 回调实现网页
 */
public class WebActivity extends AppCompatActivity implements WebPagerInterFace, SwipeRefreshLayout.OnRefreshListener {
    private WebPersenter persenter;

    private SwipeRefreshLayout refresh;
    private WebView webPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        refresh = findViewById(R.id.refresh);
        refresh.setOnRefreshListener(this);
        webPager = findViewById(R.id.webPager);

        persenter = new WebPersenter(this);//实现创建的回调接口
    }

    private String  baiduUrl = "https://www.baidu.com/";

    public void showWeb(View view) {

        persenter.loadWebPager();
    }

    @Override
    public String getUrl() {
        return baiduUrl;
    }

    @Override
    public void loadingWeb() {
        refresh.setRefreshing(true);
    }

    @Override
    public void dimissWeb() {
        refresh.setRefreshing(false);
    }

    @Override
    public void showUrl(String htmlUrl) {
        webPager.loadUrl(htmlUrl);
        webPager.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    public void onRefresh() {
        persenter.loadWebPager();
    }
}
