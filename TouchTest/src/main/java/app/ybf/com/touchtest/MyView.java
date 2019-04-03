package app.ybf.com.touchtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class MyView extends View {
    private static String TAG ="TestEvent";
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d(TAG, "View onTouchEvent :" +":" +getActionName(event));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "View dispatchTouchEvent :" +"true:"+ getActionName(event));
        return true;//super.dispatchTouchEvent(event);
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
