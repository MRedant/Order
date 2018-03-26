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

        orderRepository.addOrder(Order.OrderBuilder.builder()
                                        .withCustomer(customerService.getCustomerById(inComingOrder.getCustomer()))
                                        .withOrderedItemList(orderedItemList)
                                        .build());

        return calculateTotalPriceOfOrder(orderedItemList);
    }

    private Double calculateTotalPriceOfOrder (List<OrderedItem> orderList){
       return orderList.stream()
               .mapToDouble(e->e.getPriceOrdered().doubleValue()*e.getOrderedAmount())
               .sum();
    }

    private List<OrderedItem> assembleOrderList (List<ItemGroup> orderList){
        List<OrderedItem> returnList = new ArrayList<>();
        for (ItemGroup item:orderList) {
            Item orderedItem = itemService.getItemById(item.getItemId());
            returnList.add(OrderedItem.OrderedItemBuilder.builder()
                    .withItemId(orderedItem.getItemId())
                    .withOrderedAmount(item.getAmount())
                    .withPriceOrdered(orderedItem.getPrice())
                    .withShippingDate(calculateShippingDateForItem(orderedItem,item.getAmount()))
                    .build());
        }
        return returnList;
    }

    private Instant calculateShippingDateForItem(Item item, Integer orderedAmount){
        if (item.getItemStock()>=orderedAmount) {
            return Instant.now().plusSeconds(86400); //86400sec = 1 day
        }
        return Instant.now().plusSeconds(604800); //604800sec = 1 week
    }
}
