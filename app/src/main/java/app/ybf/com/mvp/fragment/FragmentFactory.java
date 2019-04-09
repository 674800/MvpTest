package app.ybf.com.mvp.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by ybf on 2019/4/9.
 * fragment的工厂类
 */
public class FragmentFactory {
/**
 * 根据资源id返回不同的fragment
 */   public static Fragment createForMain(int position) {
    Fragment fragment = null;
    switch (position) {
        case 0:
            fragment = new HomeFragment();
            break;
        case 1:
            fragment = new LocationFragment();
            break;
        case 2:
            fragment = new LikeFragment();
            break;
        case 3:
            fragment = new PerisonFragment();
    }
    return fragment;
}
}
