package be.cm.mredant.item;

import java.util.UUID;

public class ItemDto {

    private String itemId;
    private String itemName;
    private String itemDescription;
    private Double price;
    private Integer itemStock;

    private ItemDto() {
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getItemStock() {
        return itemStock;
    }


    public static ItemDto builder() {
        return new ItemDto();
    }

    public ItemDto withItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public ItemDto withItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public ItemDto withPrice(Double price) {
        this.price = price.doubleValue();
        return this;
    }

    public ItemDto withItemStock(Integer itemStock) {
        this.itemStock = itemStock;
        return this;
    }

    public ItemDto withItemId(UUID itemId){
        this.itemId = itemId.toString();
        return this;
    }


}
