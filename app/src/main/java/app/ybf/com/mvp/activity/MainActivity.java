package app.ybf.com.mvp.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.ybf.com.mvp.MyApplication;
import app.ybf.com.mvp.R;
import app.ybf.com.mvp.Utils.LogUtils;
import app.ybf.com.mvp.adapter.ViewpagerAdapter;
import app.ybf.com.mvp.fragment.HomeFragment;
import app.ybf.com.mvp.fragment.LikeFragment;
import app.ybf.com.mvp.fragment.LocationFragment;
import app.ybf.com.mvp.fragment.PerisonFragment;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_location)
    RadioButton rbLocation;
    @BindView(R.id.rb_like)
    RadioButton rbLike;
    @BindView(R.id.rb_me)
    RadioButton rbMe;
    private String TAG = getClass().getSimpleName();

    @BindView(R.id.layout_contentView)
    LinearLayout layoutContentView;
    @BindView(R.id.tv_info)
    TextView tvInfo;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.left)
    RelativeLayout left;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    private List<Fragment> list = new ArrayList<>();
    private static final int Home = 0;
    private static final int Location = 1;
    private static final int Like = 2;
    private static final int Persion = 3;

    private TextView tv_title;
    private ImageView Img_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void setIconOnclick() {
        LogUtils.i(TAG,"setIconOnclick");
        int position = viewpager.getCurrentItem();
        if(position == Home){
            drawerlayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void initView() {
        btn1.setOnClickListener(this);
        rbHome.setOnClickListener(this);
        rbLocation.setOnClickListener(this);
        rbLike.setOnClickListener(this);
        rbMe.setOnClickListener(this);
        drawerlayout.addDrawerListener(mDrawerListener);
        initFragment();
    }

    /**
     *拖拽监听
     */
    DrawerLayout.DrawerListener mDrawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
            getSupportActionBar().hide();
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
            getSupportActionBar().show();
        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
    /**
     * 初始化frament
     */
    private void initFragment() {
        Fragment homefragment = new HomeFragment();
        Fragment locationfragment = new LocationFragment();
        Fragment likefragment = new LikeFragment();
        Fragment persionfragment = new PerisonFragment();
        list.add(homefragment);
        list.add(locationfragment);
        list.add(likefragment);
        list.add(persionfragment);
    }

    @Override
    public void initData() {
        android.support.v4.app.FragmentManager mFragmentManager = getSupportFragmentManager();
        ViewpagerAdapter adapter = new ViewpagerAdapter(mFragmentManager, list);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(Home);
        setFragmentTitle(Home);
        viewpager.addOnPageChangeListener(monPageChangeListener);
    }

    /**
     * viewPager改变监听
     */
    ViewPager.OnPageChangeListener monPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setFragmentTitle(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void setFragmentTitle(int position) {
        switch (position) {
            case Home:
                tv_title.setText("Home");
                Img_title.setImageResource(R.mipmap.icon);
                rbHome.setChecked(true);
                break;
            case Location:
                tv_title.setText("Location");
                Img_title.setImageResource(R.mipmap.locat);
                rbLocation.setChecked(true);
                break;
            case Like:
                tv_title.setText("Like");
                Img_title.setImageResource(R.mipmap.pic);
                rbLike.setChecked(true);
                break;
            case Persion:
                tv_title.setText("Persion");
                Img_title.setImageResource(R.mipmap.ico);
                rbMe.setChecked(true);
                break;
        }
    }

    @Override
    public void setTitle(TextView tv_title) {
        this.tv_title = tv_title;

    }

    @Override
    public void setTitleImag(ImageView img_title) {
        super.setTitleImag(img_title);
        this.Img_title = img_title;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                LogUtils.i(TAG, "bt1");
                drawerlayout.closeDrawers();
                Toast.makeText(MyApplication.getInstance(), "bt1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_home:
                viewpager.setCurrentItem(Home);
                setFragmentTitle(Home);
                break;
            case R.id.rb_location:
                viewpager.setCurrentItem(Location);
                setFragmentTitle(Location);
                break;
            case R.id.rb_like:
                viewpager.setCurrentItem(Like);
                setFragmentTitle(Like);
                break;
            case R.id.rb_me:
                viewpager.setCurrentItem(Persion);
                setFragmentTitle(Persion);
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        MyApplication.isopen = false;
    }
}
