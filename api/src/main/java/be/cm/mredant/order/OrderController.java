package be.cm.mredant.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/order"})
public class OrderController {

    private OrderMapper orderMapper;
    private OrderService orderService;

    @Inject
    public OrderController(OrderMapper orderMapper, OrderService orderService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
    }

    @PostMapping(path = "/{customerId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Double addNewOrder(@PathVariable("customerId") String customerId, @RequestBody List<OrderDto> orderDtoList) {
        return orderService.addOrders(
                UUID.fromString(customerId)
                ,orderDtoList.stream()
                    .map(e->orderMapper.toDomain(e))
                    .collect(Collectors.toList()));
    }

}
