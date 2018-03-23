package be.cm.mredant.customer.databases;

import be.cm.mredant.customer.Customer;
import be.cm.mredant.exceptions.EntryAlreadyExistsInDatabaseException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class CustomerDatabase {

    private List<Customer> customerDatabase;

    public CustomerDatabase() {
        this.customerDatabase = new ArrayList<>();
    }

    public Customer addNewCustomer(Customer customer) throws EntryAlreadyExistsInDatabaseException{
        if (customerDatabaseContainsCustomer(customer)) {
            throw new EntryAlreadyExistsInDatabaseException(customer.getCustomerId().toString(),"CustomerDatabase");
        }
        customerDatabase.add(customer);
        return customer;
    }

    private boolean customerDatabaseContainsCustomer(Customer customer) {
        boolean contains = false;
        for (Customer item : customerDatabase) {
            if (item.equals(customer)) contains = true;
        }
        return contains;
    }
}
