package be.cm.mredant.order;

import be.cm.mredant.customer.CustomerDto;

import java.util.List;

public class OrderDto {

    private String orderNr;
    private CustomerDto customer;
    private List<OrderedItemDto> orderedItemList;
    private Double totalOrderPrice;

    private OrderDto(String orderNr, CustomerDto customer, List<OrderedItemDto> orderedItemList, Double totalOrderPrice) {
        this.orderNr = orderNr;
        this.customer = customer;
        this.orderedItemList = orderedItemList;
        this.totalOrderPrice = totalOrderPrice;
    }

    public String getOrderNr() {
        return orderNr;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public Double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public List<OrderedItemDto> getOrderedItemList() {
        return orderedItemList;
    }

    public static class OrderDtoBuilder {
        private String orderNr;
        private CustomerDto customer;
        private List<OrderedItemDto> orderedItemList;
        private Double totalOrderPrice;

        public static OrderDtoBuilder builder() {
            return new OrderDtoBuilder();
        }

        public OrderDtoBuilder withOrderNr(String orderNr) {
            this.orderNr = orderNr;
            return this;
        }

        public OrderDtoBuilder withCustomer(CustomerDto customer) {
            this.customer = customer;
            return this;
        }

        public OrderDtoBuilder withOrderedItemList(List<OrderedItemDto> orderedItemList) {
            this.orderedItemList = orderedItemList;
            return this;
        }

        public OrderDtoBuilder withTotalOrderPrice(Double totalOrderPrice){
            this.totalOrderPrice=totalOrderPrice;
            return this;
        }

        public OrderDto build() {
            return new OrderDto(orderNr, customer, orderedItemList, totalOrderPrice);
        }
    }
}
