package be.cm.mredant.order;

import be.cm.mredant.item.ItemMapper;
import be.cm.mredant.order.incomingOrders.InComingOrderDto;
import be.cm.mredant.order.incomingOrders.InComingOrderMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @GetMapping(path = "/{customerId}",produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public  Map<Double, List<OrderDto>> getAllOrdersForCustomer (@PathVariable("customerId")String customerId){
        Map<Double, List<OrderDto>> returnMap = new HashMap<>();
        List<OrderDto> valueList = orderService.getAllOrdersForCustomerId(customerId).stream()
                .map(e->orderMapper.toDto(e))
                .collect(Collectors.toList());
        Double totalPriceAllOrders = orderService.getTotalPriceOfAllOrdersForAListOfOrders(orderService.getAllOrdersForCustomerId(customerId));
        returnMap.put(totalPriceAllOrders,valueList);
        return returnMap;
    }

}
