package be.cm.mredant.customer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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

    public Customer getCustomerById(String customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }
}
