package app.ybf.com.mvp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.ybf.com.mvp.Login.LoginIngerface;
import app.ybf.com.mvp.Login.present;
import app.ybf.com.mvp.MyApplication;
import app.ybf.com.mvp.R;
import app.ybf.com.mvp.Utils.LogUtils;
import app.ybf.com.mvp.Utils.SharedPreferencesHelper;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ybf on 2019/3/26.
 */
public class SplashActivity extends Activity implements LoginIngerface {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_enter)
    Button btnEnter;
    private String TAG = getClass().getSimpleName();

    private boolean isFrist = false;
    private boolean isopen = false;
    private present mpresent;

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
        ButterKnife.bind(this);
        findViewById(R.id.Ly_splash).setBackgroundResource(R.mipmap.bg_f);

        mpresent = new present();
        mpresent.setPresentLinister(this);

        enterMainActivity(2000);
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

    public void statrMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        MyApplication.isopen = true;
        finish();
    }

    @Override
    public void onSuccess() {
        if (MyApplication.isopen) {
            enterMainActivity(0);
        } else {
            enterMainActivity(2000);
        }
    }

    @Override
    public void onFail() {
        Toast.makeText(MyApplication.getInstance(), "密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUserName() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassWord() {
        return etPassword.getText().toString().trim();
    }

    @OnClick(R.id.btn_enter)
    public void onClick() {
        mpresent.Login();
    }
}
