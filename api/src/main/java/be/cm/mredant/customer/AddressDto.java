package be.cm.mredant.customer;

public class AddressDto {

    private String streetName;
    private String houseNumber;
    private String cityName;
    private String postalCode;

    private AddressDto() {
    }

    public static AddressDto build() {
        return new AddressDto();
    }

    public AddressDto withStreetName(String streeName) {
        this.streetName = streeName;
        return this;
    }

    public AddressDto withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressDto withCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public AddressDto withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
