package app.ybf.com.mvp.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import app.ybf.com.mvp.R;

/**
 * Created by ybf on 2019/3/26.
 */
public abstract  class BaseActivity extends AppCompatActivity {


    private TextView tv_title;
    private ImageView img_title;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_base);
        actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.action_bar);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        initData();
        initView();
        setTitle(tv_title);
        setTitleImag(img_title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void initData() {};

    public void initView() {
        tv_title =  actionBar.getCustomView().findViewById(R.id.tv_title);
        img_title =  actionBar.getCustomView().findViewById(R.id.img_title);

    };

    /**
     * 标题必须重写
     * @param tv_title
     */
    public abstract void setTitle(TextView tv_title);

    public void setTitleImag(ImageView img_title) {};
}
