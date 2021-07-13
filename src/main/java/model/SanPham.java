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
public class SanPham implements Serializable{
    private int id;
    private String tensp;
    private String quycach;
    private double gia;
    public SanPham(){}
    public SanPham(int id, String tensp, String quycach, double gia) {
        this.id = id;
        this.tensp = tensp;
        this.quycach = quycach;
        this.gia = gia;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTensp() {
        return tensp;
    }
    public void setTensp(String tensp) {
        this.tensp = tensp;
    }
    public String getQuycach() {
        return quycach;
    }
    public void setQuycach(String quycach) {
        this.quycach = quycach;
    }
    public double getGia() {
        return gia;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
}
