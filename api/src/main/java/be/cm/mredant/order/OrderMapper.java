package be.cm.mredant.order;

import be.cm.mredant.customer.CustomerMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Collectors;

@Named
public class OrderMapper {

    @Inject
    private OrderedItemMapper orderedItemMapper;
    @Inject
    private CustomerMapper customerMapper;

    public OrderDto toDto (Order order){
        return OrderDto.OrderDtoBuilder.builder()
                .withOrderNr(order.getOrderId().toString())
                .withCustomer(customerMapper.toDto(order.getCustomer()))
                .withOrderedItemList(order.getOrderedItemList()
                        .stream()
                        .map(orderedItemMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public Order toDomain (OrderDto orderDto){
        return Order.OrderBuilder.builder()
                .withCustomer(customerMapper.toDomain(orderDto.getCustomer()))
                .withOrderedItemList(orderDto.getOrderedItemList().stream()
                        .map(orderedItemMapper::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }


}
