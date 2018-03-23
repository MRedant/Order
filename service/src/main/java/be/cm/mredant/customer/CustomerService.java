package be.cm.mredant.customer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerService {

    private CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomerToDatabase(Customer customer){
        return customerRepository.addCustomerToDatabase(customer);
    }


}
