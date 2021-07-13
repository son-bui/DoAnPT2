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
public class ItemInCart {
    private int prodId;
    private String name;
    private int spec;
    private int price;
    private int quantity;
    private int discount;
    private float totalPrice;
    private float afterDiscount;

    public float getAfterDiscount() {
        afterDiscount = (this.getTotalPrice() * (100 - discount))/100;
        if (afterDiscount < 0) {
            afterDiscount = 0;
        }
        return afterDiscount;
    }

    
    public float getTotalPrice() {
        float unitPrice = ((float)price / (float)spec);
        totalPrice = unitPrice * quantity;
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpec() {
        return spec;
    }

    public void setSpec(int spec) {
        this.spec = spec;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
}
