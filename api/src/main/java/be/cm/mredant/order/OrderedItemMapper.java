package be.cm.mredant.order;

import be.cm.mredant.order.orderedItem.OrderedItem;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.UUID;

@Named
public class OrderedItemMapper {

    public OrderedItemDto toDto(OrderedItem orderedItem){
        return OrderedItemDto.OrderedItemDtoBuilder.builder()
                .withItemId(orderedItem.getItemId())
                .withOrderedAmount(orderedItem.getOrderedAmount())
                .withPriceOrdered(orderedItem.getPriceOrdered())
                .withShippingDate(orderedItem.getShippingDate())
                .build();
    }

    public OrderedItem toDomain(OrderedItemDto orderedItemDto){
        return OrderedItem.OrderedItemBuilder.builder()
                .withOrderedAmount(orderedItemDto.getOrderedAmount())
                .withPriceOrdered(BigDecimal.valueOf(orderedItemDto.getPriceOrdered()))
                .withShippingDate(orderedItemDto.getShippingDate().toInstant())
                .build();
    }

}