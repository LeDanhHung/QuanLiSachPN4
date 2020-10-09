package com.example.quanlisachpn.SQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlisachpn.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class BIllDao {

        private MySqlite mySql;
        SQLiteDatabase db;
        public BIllDao(MySqlite mySql) {
            this.mySql = mySql;
            db = mySql.getWritableDatabase();
        }
        public void insert(HoaDon hoaDon){
            ContentValues values = new ContentValues();
            values.put("maHoaDon",hoaDon.getMaHoaDon());
            values.put("ngayMua",hoaDon.getNgayMua());
            db.insert("bill",null,values);
        }
        public List<HoaDon> getData(){
            List<HoaDon> hoaDonList = new ArrayList<>();
            Cursor cursor = db.query("bill",null,null,null,null,null,null);
            if (cursor!=null){
                while (cursor.moveToNext()){
                    String ma = cursor.getString(0);
                    String date = cursor.getString(1);
                    hoaDonList.add(new HoaDon(ma,date));
                }
            }
            cursor.close();
            return hoaDonList;
        }
        public void delete(String maHoaDon){
            db.delete("bill","maHoaDon=?",new String[]{maHoaDon});
        }
        public void update(HoaDon hoaDon,String maHoaDon){
            ContentValues values = new ContentValues();
            values.put("maHoaDon",hoaDon.getMaHoaDon());
            values.put("ngayMua",hoaDon.getNgayMua());
            db.update("bill",values,"maHoaDon=?",new String[]{maHoaDon});
        }

}
