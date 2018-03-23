package be.cm.mredant.customer;

import be.cm.mredant.customer.phoneNumber.PhoneNumber;

import javax.inject.Named;

@Named
public class PhoneNumberMapper {

    public PhoneNumberDto toDto(PhoneNumber phoneNumber) {
        return PhoneNumberDto.build()
                .withPhoneNumber(phoneNumber.getPhoneNumber());
    }

    public PhoneNumber toDomain(PhoneNumberDto phoneNumberDto) {
        return PhoneNumber.of(phoneNumberDto.getPhoneNumber());
    }
}
