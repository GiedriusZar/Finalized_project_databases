package lt.academy.entities;
import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "item_type")
    private String itemType;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_price")
    private int itemPrice;
    @Column(name = "item_stock")
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
