package app.ybf.com.mvp.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by ybf on 2019/4/9.
 */
public class NoscrollViewPager extends ViewPager {
    public NoscrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoscrollViewPager(@NonNull Context context) {
        super(context);
    }
    /**
     * 事件不处理触摸事件，返回false
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
    /**
     * false：不拦截儿子的触摸事件
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
