package app.ybf.com.mvp.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ybf on 2019/3/27.
 */
public class GuideAdapter extends PagerAdapter {
    private ArrayList<View> list;

    public GuideAdapter(ArrayList<View> list){
        super();
        this.list = list;
    }

    // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
    @Override
    public int getCount() {
        if(list != null){
            return  list.size();
        }
        return 0;
    }
    // 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (View)object;
    }
    // PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       // super.destroyItem(container, position, object);
        ( (ViewPager)container).removeView(list.get(position));
    }
    // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，
    // 我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ( (ViewPager)container).addView(list.get(position),0);
        return list.get(position);
    }
}
