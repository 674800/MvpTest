package app.ybf.com.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import app.ybf.com.mvp.fragment.FragmentFactory;

/**
 * Created by ybf on 2019/3/28.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {
    private String TAG = getClass().getSimpleName();

    public ViewpagerAdapter(FragmentManager mfragmenManager) {
        super(mfragmenManager);

    }



    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createForMain(position);
    }

    @Override
    public int getCount() {
        return 4;
    }


}
