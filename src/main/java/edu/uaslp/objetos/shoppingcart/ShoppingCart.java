package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
public class ShoppingCart {

    private List<Item> itemsList = new LinkedList<>();
    private int itemsCount;
    public boolean isEmpty() {
        return itemsList.size() == 0;
    }
    public BigDecimal getTotalCost(){
        if(itemsList.isEmpty()){
            throw new EmptyShoppingCartException();
        }
        BigDecimal totalCost = BigDecimal.ZERO;

        for(Item item: itemsList){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return totalCost;
    }
    public void addItem(Item item){

        if ((item.getCode() == null) || (item.getCode() == "")){
            throw new InvalidDataException("Null or empty string not allowed for item code");
        }if ((item.getProviderCode() == null) || (item.getProviderCode() == "")){
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }if (item.getUnitCost().compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidDataException("Cost must be greater than zero");
        }if ((item.getQuantity() < 1) || (item.getQuantity() > 5)) {
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }

        for(Item addItem: itemsList){
            if(addItem.getCode() == item.getCode() && addItem.getUnitCost().compareTo(item.getUnitCost())==0){
                addItem.setQuantity(addItem.getQuantity()+item.getQuantity());
                return;
            }
        }
        itemsList.add(item);
        //itemsCount++;
    }
    public int getItemsCount() {

        for (Item item : itemsList) {
            itemsCount = itemsCount + item.getQuantity();
        }
        return itemsCount;
    }
    public List<Item> getItems() {
        return itemsList;
    }
    public void removeItem(String itemCode) {
        for(Item removeItem: itemsList){
            if(removeItem.getCode()==itemCode){
                removeItem.setQuantity(removeItem.getQuantity()-1);
                if(removeItem.getQuantity()==0)
                    itemsList.remove(removeItem);
                return;
            }
        }
    }
}
