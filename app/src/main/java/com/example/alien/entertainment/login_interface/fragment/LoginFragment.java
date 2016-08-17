package com.example.alien.entertainment.login_interface.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alien.entertainment.MainActivity;
import com.example.alien.entertainment.R;
import com.example.alien.entertainment.login_interface.ActivityUtils;
import com.example.alien.entertainment.login_interface.db.UserExpress;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/**
 * 登陆页面
 * */
public class LoginFragment extends Fragment {


    @BindView(R.id.login_ed_username) EditText loginEdUsername;
    @BindView(R.id.login_ed_password) EditText loginEdPassword;
    @BindView(R.id.login_btn_ok) Button loginBtnOk;

    private Unbinder unbinder;
    UserExpress express;
    ActivityUtils activityUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        express = new UserExpress(getContext());
        activityUtils = new ActivityUtils(this);
    }

    /**登陆
     * 获取输入的用户名、密码
     * 判断用户名、密码是否存在、不能为空*/
    @OnClick(R.id.login_btn_ok)
    public void Login() {
        String username = loginEdUsername.getText().toString();
        String userpwd = loginEdPassword.getText().toString();
        if(username !=null&&userpwd !=null) {
            if (express.isLogin(username,userpwd)){
                Toast.makeText(getContext(), "登陆成功", Toast.LENGTH_SHORT).show();
                activityUtils.startActivity(MainActivity.class);
            }else {
                Toast.makeText(getContext(), "用户名密码错误", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(), "用户名密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
