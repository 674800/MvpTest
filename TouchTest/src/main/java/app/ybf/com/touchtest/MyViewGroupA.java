package app.ybf.com.touchtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;


public class MyViewGroupA extends LinearLayout {
    private static String TAG = "TestEvent";
    public MyViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroupA(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "ViewGroupA dispatchTouchEvent :"+":"+ getActionName(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "ViewGroupA onInterceptTouchEvent :"+":" +getActionName(ev));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "ViewGroupA onTouchEvent :"+":" + getActionName(event));
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







