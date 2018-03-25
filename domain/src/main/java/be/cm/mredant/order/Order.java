package be.cm.mredant.order;

import be.cm.mredant.customer.Customer;
import be.cm.mredant.order.orderedItem.OrderedItem;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private UUID orderId;
    private Customer customer;
    private List<OrderedItem> orderedItemList;

    private Order(List<OrderedItem> orderedItemList, Customer customer) {
        this.orderId = UUID.randomUUID();
        this.orderedItemList = orderedItemList;
        this.customer = customer;
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", orderedItemList=" + orderedItemList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderId(), order.getOrderId()) &&
                Objects.equals(getCustomer(), order.getCustomer()) &&
                Objects.equals(getOrderedItemList(), order.getOrderedItemList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOrderId(), getCustomer(), getOrderedItemList());
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
