package app.ybf.com.mvp.Utils;

import android.util.Log;

/**
 * Created by ybf on 2019/3/26.
 */
public class LogUtils {
    static boolean  isDebug = true;

    public static  void i(String Tag,String msg){
        if(isDebug){
            Log.i(Tag,msg);
        }
    }
    public static void v(String Tag,String msg){
        if(isDebug){
            Log.v(Tag,msg);
        }
    }
    public static void d(String Tag,String msg){
        if(isDebug){
            Log.d(Tag,msg);
        }
    }

    public static void e(String Tag,String msg){
        if(isDebug){
            Log.e(Tag,msg);
        }
    }
}
