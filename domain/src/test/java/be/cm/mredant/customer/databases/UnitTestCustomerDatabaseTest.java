package be.cm.mredant.customer.databases;

import be.cm.mredant.customer.Customer;
import be.cm.mredant.customer.address.Address;
import be.cm.mredant.customer.email.Email;
import be.cm.mredant.customer.phoneNumber.PhoneNumber;
import be.cm.mredant.exceptions.EntryAlreadyExistsInDatabaseException;
import be.cm.mredant.exceptions.UnknownResourceException;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UnitTestCustomerDatabaseTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void HappyPath_addNewCustomer_GivenACustomer_addCustomerToDatabase() {
        //GIVEN
        Customer testCustomer = Customer.CustomerBuilder.builder()
                .withFirstName("Jan")
                .withLastName("Metdepet")
                .withAddress(Address.of("Hutsepot","12a","Ghent","9052a"))
                .withPhoneNumber(PhoneNumber.of("01/23.45.56"))
                .withEmail(Email.of("piet@depetteflet.be"))
                .build();

        CustomerDatabase database = new CustomerDatabase();

        //WHEN
        database.addNewCustomer(testCustomer);

        //THEN
        Assertions.assertThat(database.getCustomerDatabase().get(0)).isEqualToComparingFieldByField(testCustomer);
    }

    @Test
    public void addNewCustomer_GivenACustomerWhichIsAlreadyInTheDatabase_ThrowException() {
        //GIVEN
        Customer testCustomer = Customer.CustomerBuilder.builder()
                .withFirstName("Jan")
                .withLastName("Metdepet")
                .withAddress(Address.of("Hutsepot","12a","Ghent","9052a"))
                .withPhoneNumber(PhoneNumber.of("01/23.45.67"))
                .withEmail(Email.of("piet@depetteflet.be"))
                .build();

        CustomerDatabase database = new CustomerDatabase();

        //WHEN
        database.addNewCustomer(testCustomer);

        //TRY
        thrown.expect(EntryAlreadyExistsInDatabaseException.class);
        thrown.expectMessage("CustomerDatabase already contains "+testCustomer.getFirstName()+" "+testCustomer.getLastName());
        database.addNewCustomer(testCustomer);
    }
    @Test
    public void HappyPath_getCustomerById_givenAStringId_returnsCustomer() {
        //GIVEN
        Customer testCustomer = Customer.CustomerBuilder.builder()
                .withFirstName("Jan")
                .withLastName("Metdepet")
                .withAddress(Address.of("Hutsepot","12a","Ghent","9052a"))
                .withPhoneNumber(PhoneNumber.of("01/23.45.56"))
                .withEmail(Email.of("jan@pietjoris.corneel"))
                .build();

        CustomerDatabase database = new CustomerDatabase();

        //WHEN
        database.addNewCustomer(testCustomer);

        //TRY
//        thrown.expect(EntryAlreadyExistsInDatabaseException.class);
//        thrown.expectMessage("CustomerDatabase already contains "+testCustomer.getFirstName()+" "+testCustomer.getLastName());
        Assertions.assertThat(database.getCustomerById(testCustomer.getCustomerId().toString())).isEqualToComparingFieldByField(testCustomer);
    }

    @Test
    public void getCustomerById_givenTheWorngStringId_ThrowsException() {
        //GIVEN
        Customer testCustomer = Customer.CustomerBuilder.builder()
                .withFirstName("Jan")
                .withLastName("Metdepet")
                .withAddress(Address.of("Hutsepot","12a","Ghent","9052a"))
                .withPhoneNumber(PhoneNumber.of("01/23.45.56"))
                .withEmail(Email.of("jan@pietjoris.corneel"))
                .build();

        CustomerDatabase database = new CustomerDatabase();

        //WHEN
        database.addNewCustomer(testCustomer);

        //TRY
        thrown.expect(UnknownResourceException.class);
        thrown.expectMessage("We could not find a Customer for the provided customerId :WrongId");
        database.getCustomerById("WrongId");
    }
}