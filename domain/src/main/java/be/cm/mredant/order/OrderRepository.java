package be.cm.mredant.order;

import be.cm.mredant.order.databases.OrderDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrderRepository {

    private OrderDatabase orderDatabase;

    @Inject
    public OrderRepository(OrderDatabase orderDatabase) {
        this.orderDatabase = orderDatabase;
    }

    public List<Order> getOrderList(){
        return orderDatabase.getOrderList();
    }

    public Order addOrders(Order order) {
        return orderDatabase.addNewOrderToList(order);
    }
}
