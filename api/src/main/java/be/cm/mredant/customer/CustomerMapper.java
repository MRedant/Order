package be.cm.mredant.customer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerMapper {

    @Inject
    private AddressMapper addressMapper;
    @Inject
    private EmailMapper emailMapper;
    @Inject
    private PhoneNumberMapper phoneNumberMapper;

    public CustomerDto toDto(Customer customer) {
        return CustomerDto.build()
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withAddress(addressMapper.toDto(customer.getAddress()))
                .withEmail(emailMapper.toDto(customer.getEmail()))
                .withPhoneNumber(phoneNumberMapper.toDto(customer.getPhoneNumber()));
    }

    public Customer toDomain(CustomerDto customerDto) {
        return Customer.CustomerBuilder.builder()
                .withFirstName(customerDto.getFirstName())
                .withLastName(customerDto.getLastName())
                .withAddress(addressMapper.toDomain(customerDto.getAddress()))
                .withEmail(emailMapper.toDomain(customerDto.getEmail()))
                .withPhoneNumber(phoneNumberMapper.toDomain(customerDto.getPhoneNumber()))
                .build();
    }
}
