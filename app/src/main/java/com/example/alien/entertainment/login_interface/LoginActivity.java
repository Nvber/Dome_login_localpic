package com.example.alien.entertainment.login_interface;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alien.entertainment.R;
import com.example.alien.entertainment.login_interface.fragment.LoginFragment;
import com.example.alien.entertainment.login_interface.fragment.LoginPageAdapter;
import com.example.alien.entertainment.login_interface.fragment.RigisterFragment;

import java.util.ArrayList;
import java.util.List;
/**
 * 登陆类*/
public class LoginActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> list;
    LoginPageAdapter adapter;

    ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activityUtils = new ActivityUtils(this);
        viewPager= (ViewPager) findViewById(R.id.login_register_viewpager);
        tabLayout= (TabLayout) findViewById(R.id.login_register_tab);

        indata();
        initdata();
    }

    /**Fragment+ViewPager数据*/
    private void indata() {
        list = new ArrayList<Fragment>();
        LoginFragment loginFragment = new LoginFragment();
        RigisterFragment rigisterFragment = new RigisterFragment();
        list.add(loginFragment);
        list.add(rigisterFragment);
        adapter = new LoginPageAdapter(getSupportFragmentManager());
        adapter.setList(list);
    }

    /**TabLayout+ViewPager数据*/
    private void initdata() {
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(getResources().getColor(R.color.black),getResources().getColor(R.color.red));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityUtils.finishAll();
    }
}
