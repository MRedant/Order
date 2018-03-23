package be.cm.mredant.customer;

public class PhoneNumberDto {

    private String phoneNumber;

    private PhoneNumberDto() {
    }

    public static PhoneNumberDto build() {
        return new PhoneNumberDto();
    }

    public PhoneNumberDto withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
