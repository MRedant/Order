package be.cm.mredant.customer;

import java.util.UUID;

public class CustomerDto {

    private String customerId;
    private String firstName;
    private String lastName;
    private EmailDto email;
    private AddressDto address;
    private PhoneNumberDto phoneNumber;


    public CustomerDto() {
    }

    public static CustomerDto build() {
        return new CustomerDto();
    }

    public CustomerDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto withEmail(EmailDto email) {
        this.email = email;
        return this;
    }

    public CustomerDto withAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public CustomerDto withPhoneNumber(PhoneNumberDto phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerDto withId(UUID customerId){
        this.customerId = customerId.toString();
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmailDto getEmail() {
        return email;
    }

    public AddressDto getAddress() {
        return address;
    }

    public PhoneNumberDto getPhoneNumber() {
        return phoneNumber;
    }
}
