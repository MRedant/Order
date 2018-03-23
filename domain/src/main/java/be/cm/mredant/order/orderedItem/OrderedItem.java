package be.cm.mredant.order.orderedItem;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class OrderedItem {

    private UUID itemId;
    private BigDecimal priceOrdered;
    private Integer orderedAmount;
    private Instant shippingDate;

    public OrderedItem(UUID itemId, BigDecimal priceOrdered, Integer orderedAmount) {
        this.priceOrdered = priceOrdered;
        this.orderedAmount = orderedAmount;
        this.shippingDate = null; //make a static private method for this;
        this.itemId = itemId;
    }
}
