package be.cm.mredant.customer;

import be.cm.mredant.customer.databases.CustomerDatabase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerRepository {

    private CustomerDatabase customerDatabase;

    @Inject
    public CustomerRepository(CustomerDatabase customerDatabase) {
        this.customerDatabase = customerDatabase;
    }

    public Customer addCustomerToDatabase(Customer customer){
        return customerDatabase.addNewCustomer(customer);
    }
}
