package be.cm.mredant.order.incomingOrders;

public class ItemGroupDto {
    private String itemId;
    private Integer amount;

    private ItemGroupDto() {
    }

    public String getItemId() {
        return itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public static ItemGroupDto builder() {
        return new ItemGroupDto();
    }

    public ItemGroupDto withItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroupDto withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }
}
