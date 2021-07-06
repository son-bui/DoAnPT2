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
public class KhachHang implements Serializable{
    private int id;
    private String tenKh;
    private String sdt;
    private String diaChi;
    private float soDu;
    public KhachHang(){}
    public KhachHang(int id, String tenKh, String sdt, String diaChi, float soDu) {
        this.id = id;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.soDu = soDu;
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
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public float getSoDu() {
        return soDu;
    }
    public void setSoDu(float soDu) {
        this.soDu = soDu;
    }
}
