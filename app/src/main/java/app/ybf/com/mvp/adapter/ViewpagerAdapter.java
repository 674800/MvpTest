package app.ybf.com.mvp.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.lang.reflect.Method;
import java.util.List;

import app.ybf.com.mvp.Utils.LogUtils;

/**
 * Created by ybf on 2019/3/28.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {
    private String TAG = getClass().getSimpleName();
    private FragmentManager mfragmenManager;
    private List<Fragment> lists;
    private Fragment mfragmentAtPos;

    public ViewpagerAdapter(FragmentManager mfragmenManager, List<Fragment> list) {
        super(mfragmenManager);
        this.lists = list;
        this.mfragmenManager = mfragmenManager;
    }



    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            if(mfragmentAtPos == null){

            }
        }
        return lists.get(position);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if(position == 0){
            removeFragment(container,position);
        }
        return super.instantiateItem(container, position);
    }

    private void removeFragment(ViewGroup container,int index) {
        String tag = getFragmentTag(container.getId(), index);
        LogUtils.i(TAG,"tag="+tag);
        Fragment fragment = mfragmenManager.findFragmentByTag(tag);
        if (fragment == null)
            return;
        FragmentTransaction ft = mfragmenManager.beginTransaction();
        ft.remove(fragment);
        ft.commit();
        ft = null;
        mfragmenManager.executePendingTransactions();
    }
    private String getFragmentTag(int viewId, int index) {
        try {
            Class<FragmentPagerAdapter> cls = FragmentPagerAdapter.class;
            Class<?>[] parameterTypes = { int.class, long.class };
            Method method = cls.getDeclaredMethod("makeFragmentName",
                    parameterTypes);
            method.setAccessible(true);
            String tag = (String) method.invoke(this, viewId, index);
            return tag;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
