package app.ybf.com.fragmenttest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

    private Button btn_open;
    private FrameLayout fl_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_open = findViewById(R.id.btn_open);

        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void changefragment(){
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager. beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        transaction.replace(R.id.fl_content, homeFragment);
        transaction.addToBackStack("homeFragment");
        transaction.commit();
    }

}
