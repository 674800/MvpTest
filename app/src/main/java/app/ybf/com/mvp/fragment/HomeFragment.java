package app.ybf.com.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import app.ybf.com.mvp.R;

/**
 * Created by ybf on 2019/3/28.
 */
public class HomeFragment extends BaseFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setFragmtContentView() {
        return R.layout.fragment_home;
    }
}
