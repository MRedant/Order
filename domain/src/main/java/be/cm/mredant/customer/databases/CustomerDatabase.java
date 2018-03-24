package be.cm.mredant.customer.databases;

import be.cm.mredant.customer.Customer;
import be.cm.mredant.exceptions.EntryAlreadyExistsInDatabaseException;
import be.cm.mredant.exceptions.UnknownResourceException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class CustomerDatabase {

    private List<Customer> customerDatabase;

    public CustomerDatabase() {
        this.customerDatabase = new ArrayList<>();
    }

    public List<Customer> getCustomerDatabase() {
        return Collections.unmodifiableList(customerDatabase);
    }

    public Customer addNewCustomer(Customer customer) throws EntryAlreadyExistsInDatabaseException {
        if (customerDatabaseContainsCustomerWithSameDetails(customer)) {
            throw new EntryAlreadyExistsInDatabaseException(customer.getFirstName() + " " + customer.getLastName(), "CustomerDatabase");
        }
        customerDatabase.add(customer);
        return customer;
    }

    private boolean customerDatabaseContainsCustomerWithSameDetails(Customer customer) {
        boolean contains = false;
        for (Customer item : customerDatabase) {
            if (item.equals(customer)) contains = true;
        }
        return contains;
    }

    public Customer getCustomerById(String customerId) throws UnknownResourceException {
        for (Customer item : customerDatabase) {
            if (item.getCustomerId().toString().equals(customerId)) return item;
        }
        throw new UnknownResourceException("customerId :" + customerId, "Customer");
    }
}
