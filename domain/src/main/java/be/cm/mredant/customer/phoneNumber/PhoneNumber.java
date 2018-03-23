package be.cm.mredant.customer.phoneNumber;

public class PhoneNumber {

    private String phoneNumber;

    private PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static PhoneNumber of(String phoneNumber){
        return new PhoneNumber(phoneNumber);
    }
}
