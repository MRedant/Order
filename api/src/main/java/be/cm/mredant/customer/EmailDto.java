package be.cm.mredant.customer;

public class EmailDto {

    private String emailAddress;

    private EmailDto() {
    }

    public static EmailDto build() {
        return new EmailDto();
    }

    public EmailDto withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
