package be.cm.mredant.order;

import be.cm.mredant.order.orderedItem.OrderedItem;

import javax.inject.Named;

@Named
public class OrderedItemMapper {

    public OrderedItemDto toDto(OrderedItem orderedItem){
        return OrderedItemDto.OrderedItemDtoBuilder.builder()
                .withItemId(orderedItem.getItemId())
                .withProductName(orderedItem.getProductName())
                .withOrderedAmount(orderedItem.getOrderedAmount())
                .withPriceOrdered(orderedItem.getPriceOrdered())
                .withShippingDate(orderedItem.getShippingDate())
                .withtotalOrderPrice(orderedItem.getTotalOrderPrice())
                .build();
    }

    public OrderedItem toDomain(OrderedItemDto orderedItemDto){
        return OrderedItem.OrderedItemBuilder.builder()
                .withOrderedAmount(orderedItemDto.getOrderedAmount())
                .build();
    }
}
