package be.cm.mredant.order.orderedItem;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class OrderedItem {

    private UUID itemId;
    private BigDecimal priceOrdered;
    private Integer orderedAmount;
    private Instant shippingDate;

    private OrderedItem(UUID itemId, BigDecimal priceOrdered, Instant shippingDate, Integer orderedAmount) {
        this.priceOrdered = priceOrdered;
        this.orderedAmount = orderedAmount;
        this.shippingDate = shippingDate;
        this.itemId = itemId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public BigDecimal getPriceOrdered() {
        return priceOrdered;
    }

    public Integer getOrderedAmount() {
        return orderedAmount;
    }

    public Instant getShippingDate() {
        return shippingDate;
    }

    @Override
    public String toString() {
        return "OrderedItem{" +
                "itemId=" + itemId +
                ", priceOrdered=" + priceOrdered +
                ", orderedAmount=" + orderedAmount +
                ", shippingDate=" + shippingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedItem that = (OrderedItem) o;
        return Objects.equals(getItemId(), that.getItemId()) &&
                Objects.equals(getPriceOrdered(), that.getPriceOrdered()) &&
                Objects.equals(getOrderedAmount(), that.getOrderedAmount()) &&
                Objects.equals(getShippingDate(), that.getShippingDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getItemId(), getPriceOrdered(), getOrderedAmount(), getShippingDate());
    }

    public static class OrderedItemBuilder {
        private UUID itemId;
        private BigDecimal priceOrdered;
        private Instant shippingDate;
        private Integer orderedAmount;

        public static OrderedItemBuilder builder(){
            return new OrderedItemBuilder();
        }

        public OrderedItemBuilder withItemId(UUID itemId) {
            this.itemId = itemId;
            return this;
        }

        public OrderedItemBuilder withPriceOrdered(BigDecimal priceOrdered) {
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
