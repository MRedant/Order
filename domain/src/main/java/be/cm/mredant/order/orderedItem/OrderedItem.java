package be.cm.mredant.order.orderedItem;

import java.time.Instant;
import java.util.UUID;

public class OrderedItem {

    private UUID itemId;
    private Double priceOrdered;
    private Integer orderedAmount;
    private Instant shippingDate;
    private Double totalOrderPrice;

    private OrderedItem(UUID itemId, Double priceOrdered, Instant shippingDate, Integer orderedAmount) {
        this.priceOrdered = priceOrdered;
        this.orderedAmount = orderedAmount;
        this.shippingDate = shippingDate;
        this.itemId = itemId;
        this.totalOrderPrice = orderedAmount*priceOrdered;
    }

    public UUID getItemId() {
        return itemId;
    }

    public Double getPriceOrdered() {
        return priceOrdered;
    }

    public Integer getOrderedAmount() {
        return orderedAmount;
    }

    public Instant getShippingDate() {
        return shippingDate;
    }

    public Double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public static class OrderedItemBuilder {
        private UUID itemId;
        private Double priceOrdered;
        private Instant shippingDate;
        private Integer orderedAmount;

        public static OrderedItemBuilder builder() {
            return new OrderedItemBuilder();
        }

        public OrderedItemBuilder withItemId(UUID itemId) {
            this.itemId = itemId;
            return this;
        }

        public OrderedItemBuilder withPriceOrdered(Double priceOrdered) {
            this.priceOrdered = priceOrdered;
            return this;
        }

        public OrderedItemBuilder withShippingDate(Instant shippingDate) {
            this.shippingDate = shippingDate;
            return this;
        }

        public OrderedItemBuilder withOrderedAmount(Integer orderedAmount) {
            this.orderedAmount = orderedAmount;
            return this;
        }

        public OrderedItem build() {
            return new OrderedItem(itemId, priceOrdered, shippingDate, orderedAmount);
        }
    }

}
