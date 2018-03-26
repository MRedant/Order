package be.cm.mredant.order.incomingOrders;

import javax.inject.Named;
import java.util.stream.Collectors;

@Named
public class InComingOrderMapper {

    public InComingOrder toDomain(InComingOrderDto inComingOrderDto){
        return InComingOrder.builder()
                .withCustomer(inComingOrderDto.getCustomerId())
                .withItemGroup(inComingOrderDto.getItemGroup().stream().map(e->itemGroupToDomain(e))
                .collect(Collectors.toList()));
    }

    private ItemGroup itemGroupToDomain(ItemGroupDto itemGroupDto){
        return ItemGroup.builder()
                .withAmount(itemGroupDto.getAmount())
                .withItemId(itemGroupDto.getItemId());
    }
}
