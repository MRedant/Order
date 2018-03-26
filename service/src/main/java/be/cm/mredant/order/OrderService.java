package be.cm.mredant.order;

import be.cm.mredant.customer.CustomerService;
import be.cm.mredant.item.Item;
import be.cm.mredant.item.ItemService;
import be.cm.mredant.order.incomingOrders.InComingOrder;
import be.cm.mredant.order.incomingOrders.ItemGroup;
import be.cm.mredant.order.orderedItem.OrderedItem;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Named
public class OrderService {

    private OrderRepository orderRepository;
    private ItemService itemService;
    private CustomerService customerService;

    @Inject
    public OrderService(OrderRepository orderRepository, ItemService itemService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.customerService = customerService;
    }

    public Double addOrders(InComingOrder inComingOrder) {
        List<OrderedItem> orderedItemList = assembleOrderList(inComingOrder.getItemGroup());
        return orderRepository.addOrder(Order.OrderBuilder.builder()
                .withCustomer(customerService.getCustomerById(inComingOrder.getCustomer()))
                .withOrderedItemList(orderedItemList)
                .build())
                .getTotalOrderedPrice();
    }

    private List<OrderedItem> assembleOrderList(List<ItemGroup> orderList) {
        List<OrderedItem> returnList = new ArrayList<>();
        for (ItemGroup itemGroup : orderList) {

            Item orderedItem = itemService.getItemById(itemGroup.getItemId());

            returnList.add(OrderedItem.OrderedItemBuilder.builder()
                    .withItemId(orderedItem.getItemId())
                    .withOrderedAmount(itemGroup.getAmount())
                    .withPriceOrdered(orderedItem.getPrice())
                    .withShippingDate(calculateShippingDateForItem(orderedItem, itemGroup.getAmount()))
                    .build());
            itemService.removeStockForItem(itemGroup.getItemId(), itemGroup.getAmount());
        }
        return returnList;
    }

    private Instant calculateShippingDateForItem(Item item, Integer orderedAmount) {
        if (item.getItemStock() >= orderedAmount) {
            return Instant.now().plusSeconds(86400); //86400sec = 1 day
        }
        return Instant.now().plusSeconds(604800); //604800sec = 1 week
    }

    public List<Order> getAllOrdersForCustomerId(String customerId) {
        return orderRepository.getOrderList().stream()
                .filter(e -> e.getCustomer().getCustomerId().toString().equals(customerId))
                .collect(Collectors.toList());
    }

    public Double getTotalPriceOfAllOrdersForAListOfOrders(List<Order> customerOrders) {
        return customerOrders.stream()
                .mapToDouble(Order::getTotalOrderedPrice)
                .sum();
    }
}
