package be.cm.mredant.order.incomingOrders;

import java.util.List;

public class InComingOrderDto {
    private String customerId;
    private List<ItemGroupDto> itemGroup;

    private InComingOrderDto() {
    }

    public String getCustomer() {
        return customerId;
    }

    public List<ItemGroupDto> getItemGroup() {
        return itemGroup;
    }

    public static InComingOrderDto builder(){
        return new InComingOrderDto();
    }

    public InComingOrderDto withCustomer(String customerId){
        this.customerId=customerId;
        return this;
    }

    public InComingOrderDto withItemGroup(List<ItemGroupDto> itemGroup){
        this.itemGroup=itemGroup;
        return this;
    }
}
