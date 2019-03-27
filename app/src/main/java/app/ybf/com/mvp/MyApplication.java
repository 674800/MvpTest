package app.ybf.com.mvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by ybf on 2019/3/26.
 */
public class MyApplication extends Application {
    private  static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
       mContext = getApplicationContext();

    }

    public static Context getInstance(){
        return mContext;
    }
}
