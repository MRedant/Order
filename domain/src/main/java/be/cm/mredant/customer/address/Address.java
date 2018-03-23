package be.cm.mredant.customer.address;

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
