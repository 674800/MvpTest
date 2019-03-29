package app.ybf.com.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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


                break;
        }
    }




}
