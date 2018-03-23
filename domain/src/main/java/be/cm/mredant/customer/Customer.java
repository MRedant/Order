package be.cm.mredant.customer;

import be.cm.mredant.customer.address.Address;
import be.cm.mredant.customer.email.Email;
import be.cm.mredant.customer.phoneNumber.PhoneNumber;

import java.util.UUID;

public class Customer {

    private UUID customerId;
    private String firstName;
    private String lastName;
    private Email email;
    private Address address;
    private PhoneNumber phoneNumber;
}
