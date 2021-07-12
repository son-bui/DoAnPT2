/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Trung
 */
public class GioHang {
    private int idSp;
    private String tenSp;
    private int soLuong;
    private double gia;
    public GioHang() {}
    public GioHang(int idSp, String tenSp, int soLuong, double gia) {
        this.idSp = idSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getIdSp() {
        return idSp;
    }

    public void setIdSp(int idSp) {
        this.idSp = idSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
