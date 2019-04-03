package app.ybf.com.touchtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;


public class MyViewGroupB extends LinearLayout{
    private static String TAG = "TestEvent";
    public MyViewGroupB(Context context) {
        super(context);
    }

    public MyViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroupB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "ViewGroupB dispatchTouchEvent :" +":" + getActionName(ev));
        return  super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "ViewGroupB onInterceptTouchEvent :"+":" +getActionName(ev));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "ViewGroupB onTouchEvent :"+":"+getActionName(event));
        return super.onTouchEvent(event);
    }

    public String getActionName(MotionEvent event){
        if(event.getAction() == 0){
            return "ACTION_DOWN";
        }else if(event.getAction() ==1){
            return "ACTION_UP";
        }else if(event.getAction() ==2){
            return "ACTION_MOVE";
        }else if(event.getAction() ==3 ){
            return "ACTION_CANCEL";
        }
        return  "";
    }
}
