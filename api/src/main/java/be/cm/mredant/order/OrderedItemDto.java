package be.cm.mredant.order;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class OrderedItemDto {

    private String itemId;
    private String productName;
    private Double priceOrdered;
    private Integer orderedAmount;
    private Date shippingDate;
    private Double totalOrderPrice;

    private OrderedItemDto(String itemId, String productName, Double priceOrdered, Integer orderedAmount, Date shippingDate, Double totalOrderPrice) {
        this.itemId = itemId;
        this.productName = productName;
        this.priceOrdered = priceOrdered;
        this.orderedAmount = orderedAmount;
        this.shippingDate = shippingDate;
        this.totalOrderPrice = totalOrderPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public String getProductName() {
        return productName;
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
        private String productName;
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

        public OrderedItemDtoBuilder withProductName(String productName) {
            this.productName = productName;
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

        public OrderedItemDtoBuilder withtotalOrderPrice(Double totalOrderPrice) {
            this.totalOrderPrice = totalOrderPrice;
            return this;
        }

        public OrderedItemDto build() {
            return new OrderedItemDto(itemId, productName, priceOrdered, orderedAmount, shippingDate, totalOrderPrice);
        }
    }
}

