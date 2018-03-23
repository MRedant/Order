package be.cm.mredant.order.orderedItem;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class OrderedItem {

    private UUID itemId;
    private BigDecimal priceOrdered;
    private Integer orderedAmount;
    private Instant shippingDate;

}
