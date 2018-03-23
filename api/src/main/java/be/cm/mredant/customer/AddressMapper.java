package be.cm.mredant.customer;

import be.cm.mredant.customer.address.Address;

import javax.inject.Named;

@Named
public class AddressMapper {

    public AddressDto toDto(Address address) {
        return AddressDto.build()
                .withStreetName(address.getStreetName())
                .withHouseNumber(address.getHouseNumber())
                .withCityName(address.getCityName())
                .withPostalCode(address.getPostalCode());
    }

    public Address toDomain(AddressDto addressDto) {
        return Address.of(addressDto.getStreetName()
                , addressDto.getHouseNumber()
                , addressDto.getCityName()
                , addressDto.getPostalCode());
    }
}
