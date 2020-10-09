package com.example.quanlisachpn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.quanlisachpn.SQL.BIllDao;
import com.example.quanlisachpn.SQL.BIllDetailDao;
import com.example.quanlisachpn.SQL.BookDao;
import com.example.quanlisachpn.SQL.BookTypeDao;
import com.example.quanlisachpn.SQL.MySqlite;
import com.example.quanlisachpn.model.HoaDon;
import com.example.quanlisachpn.model.HoaDonChiTiet;
import com.example.quanlisachpn.model.Sach;
import com.example.quanlisachpn.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TrangChuAcivity extends AppCompatActivity {
    LinearLayout layoutNguoiDung,layoutGioiThieu,layoutHoaDon,layoutTheLoai,layoutSach,layoutThongKe;
    public static List<Sach> sachList;
    public static List<TheLoai> theLoaiList;
    public static List<HoaDon> hoaDonList;
    public static List<HoaDonChiTiet> hoaDonChiTietList;
    public static BookTypeDao bookTypeDao;
    public static BookDao bookDao;
    public static BIllDetailDao bIllDetailDao;
    public static BIllDao bIllDao;
    MySqlite mySqlite;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_acivity);
        hoaDonChiTietList=new ArrayList<>();
        hoaDonChiTietList.add(new HoaDonChiTiet(7,"kjhj","ấdass","đâsdas"));

        anhXa();
        initialization();
        theLoaiList = bookTypeDao.getData();
        sachList = bookDao.getData();
        hoaDonList = bIllDao.getData();
        hoaDonChiTietList = bIllDetailDao.getData();


        layoutThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrangChuAcivity.this,ThongKeActivity.class));
            }
        });

        layoutTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrangChuAcivity.this, TheLoaiActivity.class));
            }
        });

        layoutSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrangChuAcivity.this,QuanLiSachActivity.class));
            }
        });

        layoutHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrangChuAcivity.this,HoaDonActivity.class));
            }
        });
        layoutGioiThieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrangChuAcivity.this,GioiThieuActivity.class));
            }
        });

        layoutNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrangChuAcivity.this, QlNguoiDungActivity.class));
            }
        });

    }

    public void anhXa(){
        layoutNguoiDung = findViewById(R.id.layoutNguoiDung);
        layoutGioiThieu = findViewById(R.id.layoutGioiThieu);
        layoutHoaDon = findViewById(R.id.layoutHoaDon);
        layoutSach = findViewById(R.id.layoutSach);
        layoutTheLoai = findViewById(R.id.layoutTheLoai);
        layoutThongKe = findViewById(R.id.layoutThongKe);
    }
    public void initialization() {
        sachList = new ArrayList<>();
        theLoaiList = new ArrayList<>();
        hoaDonList = new ArrayList<>();
        hoaDonChiTietList = new ArrayList<>();
        mySqlite = new MySqlite(this);
        bookDao = new BookDao(mySqlite);
        bookTypeDao = new BookTypeDao(mySqlite);
        bIllDao = new BIllDao(mySqlite);
        bIllDetailDao = new BIllDetailDao(mySqlite);
    }
}
