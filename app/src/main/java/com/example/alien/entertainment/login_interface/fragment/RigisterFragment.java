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
import com.example.alien.entertainment.login_interface.db.User;
import com.example.alien.entertainment.login_interface.db.UserExpress;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**注册页面
 * */
public class RigisterFragment extends Fragment {

    @BindView(R.id.register_ed_username)
    EditText registerEdUsername;
    @BindView(R.id.register_ed_pwd)
    EditText registerEdPwd;
    @BindView(R.id.register_btn_ok)
    Button registerBtnOk;

    UserExpress express;
    private Unbinder unbinder;
    ActivityUtils activityUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rigister_fragment, container,false);
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

    /**
     * 注册
     * 获取输入的用户名、密码
     * 判断用户名是否存在、用户名和密码不能为空
     */
    @OnClick(R.id.register_btn_ok)
    public void onClick() {
        String username = registerEdUsername.getText().toString();
        String userpwd = registerEdPwd.getText().toString();
        User user = new User(username,userpwd);
        if(user.getUserpwd()!=null&&user.getUsername()!=null) {
            if (!express.isExsit(user.getUsername())){
                Toast.makeText(getContext(), "注册成功", Toast.LENGTH_SHORT).show();
                express.addUser(user);
                activityUtils.startActivity(MainActivity.class);
                }else {
                Toast.makeText(getContext(), "用户已存在", Toast.LENGTH_SHORT).show();
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
