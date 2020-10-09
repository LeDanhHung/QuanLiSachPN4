package com.example.quanlisachpn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quanlisachpn.adapter.RecyclerHoaDon;
import com.example.quanlisachpn.model.HoaDon;
import com.example.quanlisachpn.model.HoaDonChiTiet;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HoaDonActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerHoaDon recyclerHoaDon;
    List<HoaDon>hoaDonList;
    Button buttonthem;

    public static List<String> spinnerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        recyclerView = findViewById(R.id.rcvHD);
        spinnerList= new ArrayList<>();
        hoaDonList= new ArrayList<>();
        spinnerList.add("Truyện ngắn");
        spinnerList.add("Sách Giáo Khoa");
        spinnerList.add("Toán");
        hoaDonList = TrangChuAcivity.hoaDonList;
        recyclerHoaDon = new RecyclerHoaDon(hoaDonList,this,R.layout.recycler_hoadon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerHoaDon);
        buttonthem = findViewById(R.id.btnThemhd);
    }

    public void themhd(View view) {
//        String ma = hoaDonList.get(holder.getAdapterPosition()).textButton;
//        final int position = holder.getAdapterPosition();

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Them hóa đơn");
        builder.setCancelable(false);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view1 = inflater.inflate(R.layout.them_hoadon, null);
        builder.setView(view1);
        final TextInputEditText txtMaHoaDon, txtSoLuong;
        final TextView textNgay = view1.findViewById(R.id.textNgay);
        Button btnNgay = view1.findViewById(R.id.btnChonNgay);
        Spinner spinner = view1.findViewById(R.id.spinnerThemHD);
        txtMaHoaDon = view1.findViewById(R.id.txtMaHDThemHD);
        txtSoLuong = view1.findViewById(R.id.txtSoLuongThemHD);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, HoaDonActivity.spinnerList);
        spinner.setAdapter(arrayAdapter);
        final String[] maSach = {null};
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maSach[0] = HoaDonActivity.spinnerList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(HoaDonActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            textNgay.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        }
                    }, year, month, day);
                    datePickerDialog.show();
                }
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
//        final String idHoaDon = hoaDonList.get(position).getMaHoaDon();
//        final String idHoaDonChiTiet = String.valueOf(TrangChuAcivity.hoaDonChiTietList.get(position).getId());
        builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String ma = txtMaHoaDon.getText().toString().trim();
                String soLuong = txtSoLuong.getText().toString().trim();
                String ngay = textNgay.getText().toString().trim();
                TrangChuAcivity.hoaDonList.add( new HoaDon(ma, ngay));
                TrangChuAcivity.bIllDao.insert(new HoaDon(ma, ngay));
                TrangChuAcivity.hoaDonChiTietList.add( new HoaDonChiTiet(ma, maSach[0], soLuong));
                TrangChuAcivity.bIllDetailDao.insert(new HoaDonChiTiet(ma, maSach[0], soLuong));
                recyclerHoaDon.notifyItemInserted(hoaDonList.size());
            }
        });
        builder.show();
    }
}
