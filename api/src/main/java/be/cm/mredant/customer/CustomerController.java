package be.cm.mredant.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = {"/customer"})
public class CustomerController {

    private CustomerService customerService;
    private CustomerMapper customerMapper;

    @Inject
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto addCustomerToDatabase (@RequestBody CustomerDto customerDto){
        return customerMapper.toDto(customerService.addCustomerToDatabase(customerMapper.toDomain(customerDto)));
    }

    @GetMapping(path = "/{customerId}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerByCustomerId (@PathVariable String customerId){
        return customerMapper.toDto(customerService.getCustomerById(customerId));
    }
    @GetMapping(path = "/all", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getCustomerByCustomerId (){
        return customerService.getAllCustomers().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }
}
