package com.example.quanlisachpn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.quanlisachpn.model.User;
import com.google.android.material.textfield.TextInputEditText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DangKiActivity extends AppCompatActivity {
    Button btnHuy, btnDangKi, btnGetImage;
    ImageView img;
    TextInputEditText txtUser, txtSdt, txtPass, txtConfimPass;
    Bitmap bm = null;
    public static List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        anhXa();
        userList = new ArrayList<>();
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangKiActivity.this, DangNhapActivity.class));
            }
        });

        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              if (img.getDrawable()==null){
////                  Toast.makeText(DangKiActivity.this, "Bạn chưa chọn ảnh đại diện", Toast.LENGTH_SHORT).show();
////              }
                userList.add(new User(txtUser.getText().toString(),txtSdt.getText().toString(),txtPass.getText().toString(),bm));
                startActivity(new Intent(getApplicationContext(), QlNguoiDungActivity.class));
            }
        });

        btnGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, 123);
                } else {
                    ActivityCompat.requestPermissions(DangKiActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1234);

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && requestCode == 123 && resultCode == RESULT_OK) {
            InputStream inputStream = null;
            try {
                inputStream = getContentResolver().openInputStream(data.getData());
                bm = BitmapFactory.decodeStream(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (inputStream!=null) {
                img.setImageBitmap(bm);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void anhXa() {
        btnHuy = findViewById(R.id.btnDangKiHuy);
        btnDangKi = findViewById(R.id.btnDangKi2);
        img = findViewById(R.id.imagFile);
        txtUser = findViewById(R.id.txtDangKiUser);
        txtSdt = findViewById(R.id.txtDangKiSdt);
        txtPass = findViewById(R.id.txtDangKiPass);
        txtConfimPass = findViewById(R.id.txtDangKiConfimPass);
        btnGetImage = findViewById(R.id.getImage);
    }
}
