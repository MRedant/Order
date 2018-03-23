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

    Customer(String firstName, String lastName, Email email, Address address, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.customerId = UUID.randomUUID();
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public static class CustomerBuilder {
        private String firstName;
        private String lastName;
        private Email email;
        private Address address;
        private PhoneNumber phoneNumber;

        public static CustomerBuilder builder() {
            return new CustomerBuilder();
        }

        public CustomerBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder withEmail(Email email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Customer build() {
            return new Customer(firstName, lastName, email, address, phoneNumber);
        }
    }
}
