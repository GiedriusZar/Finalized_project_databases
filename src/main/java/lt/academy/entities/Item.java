package lt.academy.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item{

    private Long id;
    private String itemType;
    private String itemName;
    private int itemPrice;
    private int itemStock;

    public Item(String itemType, String itemName, Long itemID, int itemPrice, int itemStock) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.id = itemID;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;


    }

    public Item() {
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemID() {
        return id;
    }

    public void setItemID(Long itemID) {
        this.id = itemID;
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
                ", ItemID: " + id +
                ", Item: " + itemName +
                ", Price: " + itemPrice +
                ", Stock left: " + itemStock + '\n';
    }
}
