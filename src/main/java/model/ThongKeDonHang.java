/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Son_Bui
 */
public class ThongKeDonHang implements Serializable {

    private int id;
    private String tenKh;
    private String ngayLap;
    private float tongTien;

    public ThongKeDonHang() {
    }

    public ThongKeDonHang(int id, String tenKh, String ngayLap, float tongTien) {
        this.id = id;
        this.tenKh = tenKh;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
}
