/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author pmtu
 */
public class NhanVien implements Serializable{
        private int manv;
    private String hoten;
    private String diachi;
    private String dienthoai;
    public NhanVien() {
    }
    public NhanVien(int manv, String hoten, String diachi, String dienthoai) {
        this.manv = manv;
        this.hoten = hoten;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
    }
    public int getManv() {
        return manv;
    }
    public void setManv(int manv) {
        this.manv = manv;
    }
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
    
    
}
