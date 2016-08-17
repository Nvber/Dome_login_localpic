package com.example.alien.entertainment.login_interface.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/16.
 * 创建数据库和表
 */
public class UserDB extends SQLiteOpenHelper {

    static  final String DB_NAME="user.db";
    static  final int DB_VERSION=1;

    public UserDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(username text,userpwd text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
