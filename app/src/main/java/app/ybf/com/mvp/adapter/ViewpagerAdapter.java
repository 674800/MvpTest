package app.ybf.com.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ybf on 2019/3/28.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> lists;


    public ViewpagerAdapter(FragmentManager mfragment, List<Fragment> list) {
        super(mfragment);
        this.lists = list;
    }



    @Override
    public Fragment getItem(int position) {
        return lists.get(position);
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
