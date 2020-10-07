package com.example.quanlisachpn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.quanlisachpn.adapter.RecyclerHoaDon;
import com.example.quanlisachpn.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDonActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerHoaDon recyclerHoaDon;
    List<HoaDon>hoaDonList;
    public static List<String> spinnerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        recyclerView = findViewById(R.id.rcvHD);
        spinnerList= new ArrayList<>();
        hoaDonList= new ArrayList<>();
        hoaDonList.add(new HoaDon("adasd","26092001"));
        recyclerHoaDon = new RecyclerHoaDon(hoaDonList,this,R.layout.recycler_hoadon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerHoaDon);
    }

}
