package com.example.quanlisachpn.SQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlisachpn.model.User;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private MySqlite mySqlite;
    SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
    public UserDao(MySqlite mySqlite){
        this.mySqlite= mySqlite;
    }
    // them
    public boolean insertUser(User user){

        ContentValues contentValues = new ContentValues();
        contentValues.put("userName",user.getName());
        contentValues.put("password",user.getPassword());
        contentValues.put("sdt",user.getPhoneNumber());
        contentValues.put("image",String.valueOf(user.getImage()));
     long kq=   sqLiteDatabase.insert("user",null,contentValues);
        if (kq > 0) return true;
        else return false;
    }
    //
    public List<User> getAlluser(){
        List<User> userList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("user",null,null,null,null,null,null);
        if (cursor.moveToNext()){
            String name = cursor.getString(0);
            String password = cursor.getString(1);
            String sdt = cursor.getString(2);
            String img = cursor.getString(3);

        }
        return userList;
    }
    public boolean updateUser(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("password",user.getPassword());
        contentValues.put("userName",user.getName());
        contentValues.put("sdt",user.getPhoneNumber());
        contentValues.put("image",String.valueOf(user.getImage()));
        long kq= sqLiteDatabase.update("user",contentValues,"userName=? AND name=?",new String[]{user.getName()});
        if (kq > 0 ) return true;
        else return false;
    }
    public boolean dellUser(String username){
        // xin quyền
        long kq = sqLiteDatabase.delete("USER","username=?",new String[]{username});
        if (kq > 0 ) return true;
        else return false;
    }
}
