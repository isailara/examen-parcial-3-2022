package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    List<Item> itemsList = new LinkedList<>();
    BigDecimal totalCost= BigDecimal.ZERO;;
    public boolean isEmpty() {
        return itemsList.size() == 0;
    }

    public BigDecimal getTotalCost() {
        for(Item item: itemsList){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return totalCost;
    }

    public void addItem(Item item){
        itemsList.add(item);
    }

    public int getItemsCount() {
        int itemsCount = itemsList.size();
        return itemsCount;
    }

    public List<Item> getItems() {
        return itemsList;
    }

    public void removeItem(String itemCode) {
        itemsList.remove(itemCode);
    }
}
