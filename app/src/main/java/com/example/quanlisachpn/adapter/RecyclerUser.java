package com.example.quanlisachpn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlisachpn.model.User;
import com.example.quanlisachpn.R;

import java.util.List;

public class RecyclerUser extends RecyclerView.Adapter<RecyclerUser.ViewHolder> {
    List<User> userList;
    Context context;
    int layout;

    public RecyclerUser(List<User> userList, Context context, int layout) {
        this.userList = userList;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textUser.setText(userList.get(position).getName());
        holder.textSdt.setText(userList.get(position).getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textUser,textSdt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageUser);
            textUser = itemView.findViewById(R.id.textUser);
            textSdt = itemView.findViewById(R.id.text2);
        }
    }
}
