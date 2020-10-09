package com.example.quanlisachpn.adapter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlisachpn.HoaDonActivity;
import com.example.quanlisachpn.R;
import com.example.quanlisachpn.TrangChuAcivity;
import com.example.quanlisachpn.model.HoaDon;
import com.example.quanlisachpn.model.HoaDonChiTiet;
import com.example.quanlisachpn.model.TheLoai;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RecyclerTheLoaiSach extends RecyclerView.Adapter<RecyclerTheLoaiSach.ViewHolder> {
    List<TheLoai> theLoaiList ;
    Context context;
    int layout;

    public RecyclerTheLoaiSach(List<TheLoai> theLoaiList, Context context, int layout) {
        this.theLoaiList = theLoaiList;
        this.context = context;
        this.layout = layout;
    }

    public RecyclerTheLoaiSach(List<TheLoai> theLoaiList) {
        this.theLoaiList = theLoaiList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final TheLoai theLoai = theLoaiList.get(position);
        holder.txtTheLoai.setText("The loai: " + theLoai.getTenTheLoai());
        holder.txtMatheLoai.setText("Mã the loai: " + theLoai.getMaTheLoai());
        holder.txtSoLuong.setText("So luong:  " + theLoai.getSoLuong());
        holder.Suatl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = holder.getAdapterPosition();

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
                builder.setTitle("Sửa the loai");
                builder.setCancelable(false);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.them_hoadon, null);
                builder.setView(view);
                final TextInputEditText txtMaHoaDon, txtSoLuong;
                final TextView textNgay = view.findViewById(R.id.textNgay);
                Button btnNgay = view.findViewById(R.id.btnChonNgay);
                Spinner spinner = view.findViewById(R.id.spinnerThemHD);
                txtMaHoaDon = view.findViewById(R.id.txtMaHDThemHD);
                txtSoLuong = view.findViewById(R.id.txtSoLuongThemHD);
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, HoaDonActivity.spinnerList);
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
                            DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
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
                final String idHoaDon = hoaDonList.get(position).getMaHoaDon();
                final String idHoaDonChiTiet = String.valueOf(TrangChuAcivity.hoaDonChiTietList.get(position).getId());
                builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ma = txtMaHoaDon.getText().toString().trim();
                        String soLuong = txtSoLuong.getText().toString().trim();
                        String ngay = textNgay.getText().toString().trim();
                        TrangChuAcivity.hoaDonList.remove(holder.getAdapterPosition());
                        TrangChuAcivity.hoaDonList.add(holder.getAdapterPosition(), new HoaDon(ma, ngay));
                        TrangChuAcivity.bIllDao.update(new HoaDon(ma, ngay), idHoaDon);
                        TrangChuAcivity.hoaDonChiTietList.remove(holder.getAdapterPosition());
                        TrangChuAcivity.hoaDonChiTietList.add(holder.getAdapterPosition(), new HoaDonChiTiet(ma, maSach[0], soLuong));
                        TrangChuAcivity.bIllDetailDao.upadate(new HoaDonChiTiet(ma, maSach[0], soLuong), idHoaDonChiTiet);
                        hoaDonList.get(position).textButton = "Edit";
                        notifyItemChanged(holder.getAdapterPosition());
                    }
                });
                builder.show();
            }


        });
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TrangChuAcivity.bIllDao.delete(TrangChuAcivity.hoaDonList.get(position).getMaHoaDon());
//                TrangChuAcivity.bIllDetailDao.delete(String.valueOf(TrangChuAcivity.hoaDonChiTietList.get(position).getId()));
//                TrangChuAcivity.hoaDonChiTietList.remove(position);
                TrangChuAcivity.bIllDao.delete(hoaDonList.get(holder.getAdapterPosition()).getMaHoaDon());
                TrangChuAcivity.bIllDetailDao.delete(String.valueOf(TrangChuAcivity.hoaDonChiTietList.get(holder.getAdapterPosition()).getId()));
                hoaDonList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTheLoai;
        TextView txtMatheLoai;
        TextView txtSoLuong;
        ImageView Suatl;
        ImageView Xoatl;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtMatheLoai = itemView.findViewById(R.id.maTL);
            txtTheLoai = itemView.findViewById(R.id.textTenTL);
            txtSoLuong = itemView.findViewById(R.id.textSoLuong);
            Suatl = itemView.findViewById(R.id.suatl);
            Xoatl = itemView.findViewById(R.id.xoatl);

        }
    }
}
