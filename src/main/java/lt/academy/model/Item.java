package lt.academy.model;

import lt.academy.enums.ItemType;

public class Item{

    private ItemType itemType;
    private String itemName;
    private String itemID;
    private int itemPrice;
    private int itemStock;

    public Item(ItemType itemType, String itemName, String itemID, int itemPrice, int itemStock) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;


    }

    public Item() {
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    @Override
    public String toString() {
        return '\n' + "Type: " + itemType +
                ", ItemID: " + itemID +
                ", Item: " + itemName +
                ", Price: " + itemPrice +
                ", Stock left: " + itemStock + '\n';
    }
}
