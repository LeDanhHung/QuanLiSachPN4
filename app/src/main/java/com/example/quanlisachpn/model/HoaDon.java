package com.example.quanlisachpn.model;

public class HoaDon {
    private String maHoaDon;
    private String ngayMua;
    public String textButton;
    public int hienthi;

    public HoaDon(String maHoaDon, String ngayMua) {
        this.maHoaDon = maHoaDon;
        this.ngayMua = ngayMua;
        this.textButton = textButton;
        this.hienthi = hienthi;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getTextButton() {
        return textButton;
    }

    public void setTextButton(String textButton) {
        this.textButton = textButton;
    }

    public int getHienthi() {
        return hienthi;
    }

    public void setHienthi(int hienthi) {
        this.hienthi = hienthi;
    }
}
