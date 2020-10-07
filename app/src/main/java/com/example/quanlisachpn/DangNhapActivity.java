package com.example.quanlisachpn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class DangNhapActivity extends AppCompatActivity {
    TextView textView;
    Button btnDangKi,btnDangNhap;
    TextInputEditText txtUser,txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        anhXa();
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(DangNhapActivity.this,DangKiActivity.class));
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")));
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangNhapActivity.this,TrangChuAcivity.class));

            }
        });
    }

    private void anhXa(){
        textView = findViewById(R.id.textDangNhap);
        btnDangKi = findViewById(R.id.btnDangKi);
        btnDangNhap =findViewById(R.id.btnDangNhap);
        txtUser =findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
    }

}
