package be.cm.mredant.item;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Item {

    private UUID itemId;
    private String itemName;
    private String itemDescription;
    private BigDecimal price;
    private Integer itemStock;

    private Item(String itemName, String itemDescription, BigDecimal price, Integer itemStock) {
        this.itemId = UUID.randomUUID();
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
        this.itemStock = itemStock;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getItemStock() {
        return itemStock;
    }

    public Item setItemId(String itemId) {
        this.itemId = UUID.fromString(itemId);
        return this;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", price=" + price +
                ", itemStock=" + itemStock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(getItemName(), item.getItemName()) &&
                Objects.equals(getItemDescription(), item.getItemDescription()) &&
                Objects.equals(getPrice(), item.getPrice()) &&
                Objects.equals(getItemStock(), item.getItemStock());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getItemName(), getItemDescription(), getPrice(), getItemStock());
    }

    public static class ItemBuilder {
        private String itemName;
        private String itemDescription;
        private BigDecimal price;
        private Integer itemStock;

        private ItemBuilder() {
        }

        public static ItemBuilder builder() {
            return new ItemBuilder();
        }

        public ItemBuilder withItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public ItemBuilder withItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
            return this;
        }

        public ItemBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withItemStock(Integer itemStock) {
            this.itemStock = itemStock;
            return this;
        }

        public Item build() {
            return new Item(itemName, itemDescription, price, itemStock);
        }
    }
}