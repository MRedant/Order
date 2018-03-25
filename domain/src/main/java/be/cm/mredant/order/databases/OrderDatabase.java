package be.cm.mredant.order.databases;

import be.cm.mredant.order.Order;

import javax.inject.Named;
import java.util.*;

@Named
public class OrderDatabase {
    private List<Order> orderList;

    public OrderDatabase() {
        this.orderList = new ArrayList<>();
    }

    public List<Order> getOrderList() {
        return Collections.unmodifiableList(orderList);
    }

    public Order addNewOrderToList(Order order){
        orderList.add(order);
        return order;
    }
}
