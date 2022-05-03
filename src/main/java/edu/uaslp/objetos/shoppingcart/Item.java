package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;

public class Item {
    String itemCode;
    String providerCode;
    int quantity;
    BigDecimal unitCost;

    public Item(String itemCode, String providerCode, BigDecimal unitCost, int quantity) {
        this.itemCode=itemCode;
        this.providerCode=providerCode;
        this.unitCost=unitCost;
        this.quantity=quantity;
    }

    public Item() {

    }

    public void setCode(String itemCode) {
        this.itemCode=itemCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode=providerCode;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost=unitCost;
    }

    public String getCode() {
        return itemCode;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }
}
