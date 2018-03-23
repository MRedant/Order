package be.cm.mredant.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.inject.Inject;

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

//    @PostMapping(produces = APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public CustomerDto addCustomerToDatabase (Customer customer)
}
