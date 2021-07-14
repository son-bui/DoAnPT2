/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trung
 */
public class GioHang {
    private List<SanPhamGh> carts = new ArrayList<SanPhamGh>();
    private int cusId;
    private Date date;
    private int discount;
    private float totalPrice;
    private float afterDiscount;
    
    
    public float getTotalPrice() {
        totalPrice = 0;
        for (SanPhamGh cart : carts) {
            totalPrice += cart.getAfterDiscount();
        }
        return totalPrice;
    }
    public float getAfterDiscount(){
        afterDiscount = (this.getTotalPrice() * (100 - discount))/100;
        if (afterDiscount < 0) {
            afterDiscount = 0;
        }
        return afterDiscount;
    }
    public void clearCart(){
        carts.clear();
    }
    
    public void addItem(SanPhamGh item){
        boolean flag = true;
        
        for (SanPhamGh iic : carts){
            if (iic.getProdId() == item.getProdId()) {
                iic.setQuantity(iic.getQuantity() + item.getQuantity());
                iic.setDiscount(item.getDiscount());
                flag = false;
            }
        }
        if (flag) {
            carts.add(item);
        }
    }

    public List<SanPhamGh> getCarts() {
        return carts;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void deleteItemByProdId(int prodId) {
        for (SanPhamGh cart : carts) {
            if (cart.getProdId() == prodId) {
                carts.remove(cart);
                return;
            }
        }
    }
}
