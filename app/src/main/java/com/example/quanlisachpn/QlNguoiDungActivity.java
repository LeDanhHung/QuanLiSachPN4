package com.example.quanlisachpn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlisachpn.adapter.RecyclerUser;

public class QlNguoiDungActivity extends AppCompatActivity {

    RecyclerUser recyclerUser;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ql_nguoi_dung);

        recyclerView = findViewById(R.id.rcvUser);
            recyclerUser = new RecyclerUser(DangKiActivity.userList, this, R.layout.recyclerview_user);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(recyclerUser);

    }
}
