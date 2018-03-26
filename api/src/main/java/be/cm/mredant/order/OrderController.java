package be.cm.mredant.order;

import be.cm.mredant.item.ItemMapper;
import be.cm.mredant.order.incomingOrders.InComingOrderDto;
import be.cm.mredant.order.incomingOrders.InComingOrderMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/order"})
public class OrderController {

    private OrderMapper orderMapper;
    private OrderService orderService;
    private ItemMapper itemMapper;
    private InComingOrderMapper inComingOrderMapper;

    @Inject
    public OrderController(InComingOrderMapper inComingOrderMapper,OrderMapper orderMapper, OrderService orderService, ItemMapper itemMapper) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.itemMapper = itemMapper;
        this.inComingOrderMapper=inComingOrderMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Double addNewOrder(@RequestBody InComingOrderDto inComingOrder) {
        return orderService.addOrders(inComingOrderMapper.toDomain(inComingOrder));
    }

}
