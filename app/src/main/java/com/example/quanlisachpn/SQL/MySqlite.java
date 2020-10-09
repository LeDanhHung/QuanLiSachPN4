package com.example.quanlisachpn.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlite extends SQLiteOpenHelper {
    public MySqlite(Context context){
        super(context,"data.sql",null,1);
    }
    // khởi tạo bảng csdl
    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_user="create table user (name NVARCHAR(50) primary key,password NVARCHAR(50) NOT  NULL,phoneNumber NCHAR(10) NOT NULL)";
        String table_book="create table book (MaSach NCHAR(5) primary key NOT  NULL ,MaTheLoai NCHAR(50) NOT  NULL ,TacGia NVARCHAR(50),NXB NVARCHAR(50),giaBia FLOAT NOT  NULL ,soLuong INTEGER )";
        String table_type="create table type (MaTheLoai CHAR(5) primary key NOT  NULL ,tenTheLoai NVARCHAR(50) NOT  NULL , soLuong INT)";
        String table_bill="create table bill (MaHoaDon NCHAR(7) primary key NOT  NULL ,NgayMua DATE NOT  NULL  )";
        String table_bill_detail="create table bill_detail (MaHDCT INTEGER primary key AUTOINCREMENT , maHoaDon NCHAR(10),maSach NCHAR(5) ,soLuongMua INTEGER  )";
        db.execSQL(table_user);
        db.execSQL(table_book);
        db.execSQL(table_type);
        db.execSQL(table_bill);
        db.execSQL(table_bill_detail);
    }
    // cập nhật cấu trúc csdl
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
