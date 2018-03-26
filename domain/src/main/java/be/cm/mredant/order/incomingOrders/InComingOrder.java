package be.cm.mredant.order.incomingOrders;

import java.util.List;

public class InComingOrder {
    private String customerId;
    private List<ItemGroup> itemGroup;

    private InComingOrder() {
    }

    public String getCustomer() {
        return customerId;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }

    public static InComingOrder builder() {
        return new InComingOrder();
    }

    public InComingOrder withCustomer(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public InComingOrder withItemGroup(List<ItemGroup> itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }
}
