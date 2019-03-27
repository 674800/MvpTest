package app.ybf.com.mvp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import app.ybf.com.mvp.R;
import app.ybf.com.mvp.Utils.SharedPreferencesHelper;
import app.ybf.com.mvp.adapter.GuideAdapter;

/**
 * Created by ybf on 2019/3/27.
 * 引导页
 */
public class GuideActivity extends Activity implements OnClickListener {
    private ViewPager viewPager;
    private GuideAdapter adapter;
    private ArrayList<View> list;
    private Button satrtBtn;

    private static final int[] pics = {R.layout.guid_view1, R.layout.guid_view2,
            R.layout.guid_view3,
            R.layout.guid_view4};

    private ImageView[] dots;
    private int currentIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
    }

    private void initData() {
        list = new ArrayList<View>();
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
            if (i == pics.length - 1) { //最后一张查找btn
                satrtBtn = view.findViewById(R.id.btn_login);
                satrtBtn.setTag("enter");
                satrtBtn.setOnClickListener(this);
            }
            list.add(view);
        }

        viewPager = (ViewPager) findViewById(R.id.vp_guide);

        adapter = new GuideAdapter(list);
        viewPager.setAdapter(adapter);
        //添加page 监听
        viewPager.addOnPageChangeListener(new PageChageLintener());
        initDots();
    }

    /**
     * 初始化圆点
     *
     * @param v
     */
    private void initDots() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[pics.length];
        for (int i = 0; i < pics.length; i++) {
            dots[i] = (ImageView) linearLayout.getChildAt(i);
            dots[i].setEnabled(false);//设置成灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(true);//设置成白色
    }

    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurrentView(int position) {
        if (position < 0 || position > pics.length) {
            return;
        }
        viewPager.setCurrentItem(position);
    }

    /**
     * 设置当前指示点
     *
     * @param position
     */
    private void setCurDot(int position) {
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().equals("enter")) {
            statrMainActivity();
            return;
        }
        int position = (Integer) v.getTag();
        setCurrentView(position);
        setCurDot(position);
    }

    public void statrMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        SharedPreferencesHelper.getInstance(this).putBooleanValue("isFrist", false);
        finish();
    }

    /**
     * 点击back键后，保存标记位。
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferencesHelper.getInstance(this).putBooleanValue("isFrist", false);
    }

    private class PageChageLintener implements ViewPager.OnPageChangeListener {
        /*当前页面被滑动时调用*/
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /*当新的页面被选中时调用*/
        @Override
        public void onPageSelected(int position) {
            setCurDot(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
