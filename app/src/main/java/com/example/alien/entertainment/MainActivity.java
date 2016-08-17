package com.example.alien.entertainment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.alien.entertainment.login_interface.ActivityUtils;
import com.example.alien.entertainment.login_interface.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login_interface)
    Button loginInterface;
    @BindView(R.id.local_image)
    Button localImage;

    ActivityUtils activityUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
    }


    @OnClick({R.id.login_interface, R.id.local_image})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_interface:
                activityUtils.startActivity(LoginActivity.class);
                break;
            case R.id.local_image:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityUtils.finishAll();
    }
}
