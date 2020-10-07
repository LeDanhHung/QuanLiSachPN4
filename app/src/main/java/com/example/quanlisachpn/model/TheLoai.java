package com.example.quanlisachpn.model;

public class TheLoai {
   private String maTheLoai, tenTheLoai;
   private int soLuong;

    public TheLoai(String maTheLoai, String tenTheLoai, int soLuong) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.soLuong = soLuong;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
