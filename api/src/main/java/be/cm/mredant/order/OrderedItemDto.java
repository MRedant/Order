package be.cm.mredant.order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class OrderedItemDto {

    private String itemId;
    private Double priceOrdered;
    private Integer orderedAmount;
    private Date shippingDate;

    private OrderedItemDto(String itemId, Double priceOrdered, Integer orderedAmount, Date shippingDate) {
        this.itemId = itemId;
        this.priceOrdered = priceOrdered;
        this.orderedAmount = orderedAmount;
        this.shippingDate = shippingDate;
    }

    public String getItemId() {
        return itemId;
    }

    public Double getPriceOrdered() {
        return priceOrdered;
    }

    public Integer getOrderedAmount() {
        return orderedAmount;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public static class OrderedItemDtoBuilder {
        private String itemId;
        private Double priceOrdered;
        private Integer orderedAmount;
        private Date shippingDate;

        public static OrderedItemDtoBuilder builder() {
            return new OrderedItemDtoBuilder();
        }

        public OrderedItemDtoBuilder withItemId(UUID itemId) {
            this.itemId = itemId.toString();
            return this;
        }

        public OrderedItemDtoBuilder withPriceOrdered(BigDecimal priceOrdered) {
            this.priceOrdered = priceOrdered.doubleValue();
            return this;
        }

        public OrderedItemDtoBuilder withOrderedAmount(Integer orderedAmount) {
            this.orderedAmount = orderedAmount;
            return this;
        }

        public OrderedItemDtoBuilder withShippingDate(Instant shippingDate) {
            this.shippingDate = Date.from(shippingDate);
            return this;
        }

        public OrderedItemDto build() {
            return new OrderedItemDto(itemId, priceOrdered, orderedAmount, shippingDate);
        }
    }
}

