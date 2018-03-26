package be.cm.mredant.order;

import be.cm.mredant.customer.Customer;
import be.cm.mredant.order.orderedItem.OrderedItem;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {

    private UUID orderId;
    private Customer customer;
    private List<OrderedItem> orderedItemList;
    private Double totalOrderedPrice;

    private Order(List<OrderedItem> orderedItemList, Customer customer) {
        this.orderId = UUID.randomUUID();
        this.orderedItemList = orderedItemList;
        this.customer = customer;
        this.totalOrderedPrice = calculateTotalOrderPrice(orderedItemList);
    }

    private Double calculateTotalOrderPrice(List<OrderedItem> orderedItemList) {
        return orderedItemList.stream()
                .mapToDouble(e->e.getOrderedAmount()*(e.getPriceOrdered()))
                .sum();
    }

    public List<OrderedItem> getOrderedItemList() {
        return Collections.unmodifiableList(orderedItemList);
    }

    public UUID getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Double getTotalOrderedPrice() {
        return totalOrderedPrice;
    }

    public static class OrderBuilder {
        private List<OrderedItem> orderedItemList;
        private Customer customer;

        public static OrderBuilder builder() {
            return new OrderBuilder();
        }

        public OrderBuilder withOrderedItemList(List<OrderedItem> orderedItemList) {
            this.orderedItemList = orderedItemList;
            return this;
        }

        public OrderBuilder withCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Order build() {
            return new Order(orderedItemList, customer);
        }
    }

}
