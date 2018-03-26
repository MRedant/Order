package be.cm.mredant.order.incomingOrders;

public class ItemGroup {
    private String itemId;
    private Integer amount;

    private ItemGroup() {
    }

    public String getItemId() {
        return itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public static ItemGroup builder() {
        return new ItemGroup();
    }

    public ItemGroup withItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroup withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }
}
