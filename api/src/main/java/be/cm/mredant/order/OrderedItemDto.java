package be.cm.mredant.order;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class OrderedItemDto {

    private String itemId;
    private Double priceOrdered;
    private Integer orderedAmount;
    private Date shippingDate;
    private Double totalOrderPrice;

    private OrderedItemDto(String itemId, Double priceOrdered, Integer orderedAmount, Date shippingDate, Double totalOrderPrice) {
        this.itemId = itemId;
        this.priceOrdered = priceOrdered;
        this.orderedAmount = orderedAmount;
        this.shippingDate = shippingDate;
        this.totalOrderPrice=totalOrderPrice;
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

    public Double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public static class OrderedItemDtoBuilder {
        private String itemId;
        private Double priceOrdered;
        private Integer orderedAmount;
        private Date shippingDate;
        private Double totalOrderPrice;

        public static OrderedItemDtoBuilder builder() {
            return new OrderedItemDtoBuilder();
        }

        public OrderedItemDtoBuilder withItemId(UUID itemId) {
            this.itemId = itemId.toString();
            return this;
        }

        public OrderedItemDtoBuilder withPriceOrdered(Double priceOrdered) {
            this.priceOrdered = priceOrdered;
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

        public OrderedItemDtoBuilder withtotalOrderPrice(Double totalOrderPrice){
            this.totalOrderPrice=totalOrderPrice;
            return this;
        }

        public OrderedItemDto build() {
            return new OrderedItemDto(itemId, priceOrdered, orderedAmount, shippingDate, totalOrderPrice);
        }
    }
}

