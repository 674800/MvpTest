package app.ybf.com.mvp.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.ybf.com.mvp.MyApplication;
import app.ybf.com.mvp.R;
import app.ybf.com.mvp.Utils.FindId.InjectView;
import app.ybf.com.mvp.Utils.FindId.Injector;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    @InjectView(R.id.drawerlayout)
    public DrawerLayout drawerLayout;
    @InjectView(R.id.btn1)
    public Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Injector.get(this).inject();
        btn1.setOnClickListener(this);
    }

    @Override
    public void initView() {
        super.initView();

    }

    @Override
    public void setTitle(TextView tv_title) {
        tv_title.setText("Home");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                drawerLayout.closeDrawers();
                Toast.makeText(MyApplication.getInstance(),"btn1",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
