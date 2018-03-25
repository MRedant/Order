package be.cm.mredant.order;

import be.cm.mredant.item.ItemService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.UUID;

@Named
public class OrderService {

    private OrderRepository orderRepository;
    private ItemService itemService;

    @Inject
    public OrderService(OrderRepository orderRepository, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    public Double addOrders(UUID customerId, List<Order> orderList) {
        Double totalPriceOfOrder = null;

        //todo write method whic adds orders to the database

        return totalPriceOfOrder;
    }
}
