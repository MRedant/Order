package be.cm.mredant.customer.address;

import java.util.Objects;

public class Address {
    private String streetName;
    private String houseNumber;
    private String cityName;
    private String postalCode;

    private Address(String streetName, String houseNumber, String cityName, String postalCode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
        this.postalCode = postalCode;
    }

    public static Address of(String streetName, String houseNumber, String cityName, String postalCode){
        return new Address (streetName,houseNumber,cityName,postalCode);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getStreetName(), address.getStreetName()) &&
                Objects.equals(getHouseNumber(), address.getHouseNumber()) &&
                Objects.equals(getCityName(), address.getCityName()) &&
                Objects.equals(getPostalCode(), address.getPostalCode());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStreetName(), getHouseNumber(), getCityName(), getPostalCode());
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", cityName='" + cityName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
