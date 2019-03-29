package app.ybf.com.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.ybf.com.mvp.R;

/**
 * Created by ybf on 2019/3/28.
 */
public class TestFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initDate() {

    }

    @Override
    public int setFragmtContentView() {
        return R.layout.fragment_test;
    }
}
