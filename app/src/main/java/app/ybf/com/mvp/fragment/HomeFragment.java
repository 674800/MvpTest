package app.ybf.com.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import app.ybf.com.mvp.MyApplication;
import app.ybf.com.mvp.R;
import app.ybf.com.mvp.Utils.LogUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ybf on 2019/3/28.
 */
public class HomeFragment extends BaseFragment {
    private String TAG = getClass().getSimpleName();
    @BindView(R.id.fragment_home_layout)
    FrameLayout fragmentHomeLayout;
    Unbinder unbinder;
    @BindView(R.id.btn_home)
    Button btnHome;
    @BindView(R.id.btn_home_open)
    Button btnHomeOpen;
    View rootView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int setFragmtContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        initDate();
    }

    @Override
    public void initView() {
        fragmentHomeLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void initDate() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
         rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtils.i(TAG,"isVisibleToUser="+isVisibleToUser);
       // getView().setVisibility(isVisibleToUser ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_home, R.id.btn_home_open})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:

                break;
            case R.id.btn_home_open:
                Toast.makeText(MyApplication.getInstance(),"open",Toast.LENGTH_SHORT).show();

                    replaceFragment(new TestFragment());

                break;
        }
    }

    //Fragment启动方法：有bug ，点击事件还在

    private void replaceFragment(Fragment fragment) {
// 1.获取FragmentManager，在活动中可以直接通过调用getFragmentManager()方法得到
        FragmentManager  fragmentManager =getFragmentManager();
// 2.开启一个事务，通过调用beginTransaction()方法开启
        FragmentTransaction  transaction = fragmentManager.beginTransaction();
// 3.向容器内添加或替换碎片，一般使用replace()方法实现，需要传入容器的id和待添加的碎片实例
        transaction.hide(this);
        transaction.add(R.id.fragment_home_layout, fragment);  //fr_container不能为fragment布局，可使用线性布局相对布局等。
// 4.使用addToBackStack()方法，将事务添加到返回栈中，填入的是用于描述返回栈的一个名字
        transaction.addToBackStack(null);
// 5.提交事物,调用commit()方法来完成
        transaction.commit();

    }


}
