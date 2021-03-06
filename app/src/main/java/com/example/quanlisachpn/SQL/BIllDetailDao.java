package com.example.quanlisachpn.SQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlisachpn.model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

public class BIllDetailDao {
    private MySqlite mySql;
    SQLiteDatabase db;
    public BIllDetailDao(MySqlite mySql) {
        this.mySql = mySql;
        db = mySql.getWritableDatabase();
    }
    public void insert(HoaDonChiTiet hoaDonChiTiet){
        ContentValues values = new ContentValues();
        values.put("maHoaDon",hoaDonChiTiet.getMaHoaDon());
        values.put("maSach",hoaDonChiTiet.getMaSach());
        values.put("soLuongMua",hoaDonChiTiet.getSoLuongMua());
        db.insert("bill_detail",null,values);
    }
    public List<HoaDonChiTiet> getData(){
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        Cursor cursor = db.query("bill_detail",null,null,null,null,null,null);
        if (cursor!=null){
            while (cursor.moveToNext()){
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String maSach = cursor.getString(cursor.getColumnIndex("maSach"));
                int soLuong = cursor.getInt(cursor.getColumnIndex("soLuongMua"));
                hoaDonChiTietList.add(new HoaDonChiTiet(maHoaDon,maSach,String.valueOf(soLuong)));

            }
        }
        cursor.close();
        return hoaDonChiTietList;
    }
    public void delete(String maHDCT){
        db.delete("bill_detail","maHDCT=?",new String[]{maHDCT});
    }
    public void upadate(HoaDonChiTiet hoaDonChiTiet,String maHDCT){
        ContentValues values = new ContentValues();
        values.put("maHoaDon",hoaDonChiTiet.getMaHoaDon());
        values.put("maSach",hoaDonChiTiet.getMaSach());
        values.put("soLuongMua",hoaDonChiTiet.getSoLuongMua());
        db.update("bill_detail",values,"maHDCT=?",new String[]{maHDCT});
    }
}
