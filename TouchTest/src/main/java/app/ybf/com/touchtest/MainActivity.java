package app.ybf.com.touchtest;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {


    /**
     * ACTION_DOWN =0;
     * ACTION_UP = 1;
     * ACTION_MOVE = 2;
     * ACTION_CANCEL= 3;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
