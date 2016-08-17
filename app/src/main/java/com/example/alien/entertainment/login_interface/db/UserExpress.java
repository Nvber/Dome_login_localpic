package com.example.alien.entertainment.login_interface.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2016/8/16.
 * 数据库操作类
 */
public class UserExpress {
    private Context context;
    private SQLiteDatabase db;

    public UserExpress(Context context) {
        this.context = context;
        UserDB ud = new UserDB(context);
        db = ud.getWritableDatabase();
    }

    /**
     * 添加方法
     * @param user
     */
    public void addUser(User user){
        ContentValues cv=new ContentValues();
        cv.put("username",user.getUsername());
        cv.put("userpwd",user.getUserpwd());
        db.insert("user", null, cv);
    }

    /**
     * 判断此用户名是否存在
     * @param username
     * @return
     */
    public boolean isExsit(String username){
        Cursor cursor = db.rawQuery("select * from user where username=?", new String[]{username});
        return cursor.moveToNext();
    }
    /**
     * 判断是否登陆成功
     * @param username
     * @param userpwd
     * @return
     */
    public boolean isLogin(String username,String userpwd){
        Cursor cursor = db.rawQuery("select * from user where username=? and userpwd=?", new String[]{username,userpwd});
        return cursor.moveToNext();
    }
}
