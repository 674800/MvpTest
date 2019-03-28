package app.ybf.com.mvp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import app.ybf.com.mvp.MyApplication;
import app.ybf.com.mvp.R;
import app.ybf.com.mvp.Utils.LogUtils;
import app.ybf.com.mvp.Utils.SharedPreferencesHelper;

/**
 * Created by ybf on 2019/3/26.
 */
public class SplashActivity extends Activity {
    private String TAG = getClass().getSimpleName();

    private boolean isFrist = false;
    private boolean isopen = false;

    /**
     * 1.进入splashActivity 页面
     * 2.判断是否第一次开启，如果是第一次开启进入guide引导页面
     * 3.如果不是第一次则进入MainActivity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFrist = SharedPreferencesHelper.getInstance(this).getBooleanValue("isFrist");
        LogUtils.i(TAG, "isFrist open :" + isFrist);
        if (isFrist) {
            startActivity(new Intent(this, GuideActivity.class));
            finish();
            SharedPreferencesHelper.getInstance(this).putBooleanValue("isFrist", false);
            return;
        }
        setContentView(R.layout.activity_splas);
        findViewById(R.id.Ly_splash).setBackgroundResource(R.mipmap.bg_f);
        if(MyApplication.isopen){
            enterMainActivity(0);
        }else{
            enterMainActivity(2000);
        }


    }

    /**
     * 延时2秒进入主界面
     */
    public void enterMainActivity(int times) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                statrMainActivity();

            }
        }, times);
    }

    public void statrMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
        MyApplication.isopen = true;
        finish();
    }
}
