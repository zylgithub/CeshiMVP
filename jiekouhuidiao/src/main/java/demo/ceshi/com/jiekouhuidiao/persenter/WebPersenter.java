package demo.ceshi.com.jiekouhuidiao.persenter;

import android.os.Handler;

import demo.ceshi.com.jiekouhuidiao.iview.WebPagerInterFace;

public class WebPersenter {
    private WebPagerInterFace interFace;//声明回调接口
    private String url;

    public WebPersenter(WebPagerInterFace interFace) {
        this.interFace = interFace;
    }

//    private int pager = 1;

    public void loadWebPager() {
//        Log.d("WebPersenter", "--模拟分页效果（页数）--" + (pager++));
        //接受需要显示的网页
        url = interFace.getUrl();
        interFace.loadingWeb();//开始加载网页
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                interFace.showUrl(url);
                interFace.dimissWeb();//网页加载完成
            }
        }, 3000);


    }
}
