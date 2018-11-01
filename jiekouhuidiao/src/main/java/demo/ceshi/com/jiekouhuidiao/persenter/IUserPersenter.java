package demo.ceshi.com.jiekouhuidiao.persenter;

import android.os.Handler;

import demo.ceshi.com.jiekouhuidiao.iview.IUserInterface;

public class IUserPersenter {
    private IUserInterface iUserInterface;
    private int i = 0;

    public IUserPersenter(IUserInterface iUserInterface) {
        this.iUserInterface = iUserInterface;
    }

    public void getData() {
        i++;
        iUserInterface.showLoading();//开始回调
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //这里可以使用网络请求
                iUserInterface.addData("michal", (00 + i), "The USA NewYourK");

                iUserInterface.dimissLoading();//结束回调

            }
        }, 3000);


    }
}
