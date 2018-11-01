package demo.ceshi.com.jiekouhuidiao.iview;

public interface WebPagerInterFace {

    String getUrl();//网页地址

    void loadingWeb();//加载页面

    void dimissWeb();//页面完成

    void showUrl(String htmlUrl);
}
