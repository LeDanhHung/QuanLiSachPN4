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
    SQLiteDatabase sqLiteDatabase;
    public UserDao(MySqlite mySqlite){
        this.mySqlite= mySqlite;
        sqLiteDatabase = mySqlite.getWritableDatabase();
    }
    // them
    public void insertUser(User user){

        ContentValues contentValues = new ContentValues();
        contentValues.put("name",user.getName());
        contentValues.put("password",user.getPassword());
        contentValues.put("phoneNumber",user.getPhoneNumber());
        sqLiteDatabase.insert("user",null,contentValues);
    }
    //
    public List<User> getAlluser(){
        List<User> userList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("user",null,null,null,null,null,null);
        if (cursor.moveToNext()){
            String name = cursor.getString(0);
            String password = cursor.getString(1);
            String sdt = cursor.getString(2);
            userList.add(new User(name,password,sdt));
        }
        return userList;
    }
    public boolean updateUser(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("password",user.getPassword());
        contentValues.put("name",user.getName());
        contentValues.put("phoneNumber",user.getPhoneNumber());
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
