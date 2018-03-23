package be.cm.mredant.customer;

import be.cm.mredant.customer.email.Email;

import javax.inject.Named;

@Named
public class EmailMapper {

    public EmailDto toDto (Email email){
        return EmailDto.build()
                .withEmailAddress(email.getEmailAddress());
    }

    public Email toDomain (EmailDto emailDto){
        return Email.of(emailDto.getEmailAddress());
    }
}
