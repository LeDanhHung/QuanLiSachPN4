package com.example.quanlisachpn.model;

public class Sach {
    private String ten,ma,ngayNhap,theLoai;
    private int soLuong;
    private float gia;

    public Sach(String ten, String ma, String ngayNhap, String theLoai, int soLuong, float gia) {
        this.ten = ten;
        this.ma = ma;
        this.ngayNhap = ngayNhap;
        this.theLoai = theLoai;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public Sach(String ten, String ma, int soLuong, String gia, String theLoai) {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
}
