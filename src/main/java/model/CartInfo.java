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
public class CartInfo {
    private List<ItemInCart> carts = new ArrayList<ItemInCart>();
    private int cusId;
    private Date date;
    private int discount;
    private float totalPrice;
    private float afterDiscount;
    
    
    public float getTotalPrice() {
        totalPrice = 0;
        for (ItemInCart cart : carts) {
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
    
    public void addItem(ItemInCart item){
        boolean flag = true;
        
        for (ItemInCart iic : carts){
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

    public List<ItemInCart> getCarts() {
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
        for (ItemInCart cart : carts) {
            if (cart.getProdId() == prodId) {
                carts.remove(cart);
                return;
            }
        }
    }
}
