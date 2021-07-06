/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author TMT
 */
public class HoaDon implements Serializable{
    private int id;
    private int maKh;
    private String ngayLap;
    private float tongTien;
    public HoaDon(){}
    public HoaDon(int id, int maKh, String ngayLap, float tongTien) {
        this.id = id;
        this.maKh = maKh;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMaKh() {
        return maKh;
    }
    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }
    public String getNgaylap() {
        return ngayLap;
    }
    public void setNgaylap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
    public float getTongtien() {
        return tongTien;
    }
    public void setTongtien(float gia) {
        this.tongTien = tongTien;
    }
}
