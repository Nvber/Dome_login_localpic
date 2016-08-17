package com.example.alien.entertainment.login_interface.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16.
 * 登陆功能适配器
 */
public class LoginPageAdapter extends FragmentPagerAdapter {

    List<Fragment> list;
    List<String> title;
    public LoginPageAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<Fragment>();
        title = new ArrayList<String>();
        title.add("登录");
        title.add("注册");
    }

    public List<Fragment> getList() {
        return list;
    }

    public void setList(List<Fragment> list) {
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
