package be.cm.mredant.order;

import be.cm.mredant.customer.Customer;
import be.cm.mredant.customer.CustomerService;
import be.cm.mredant.customer.address.Address;
import be.cm.mredant.customer.email.Email;
import be.cm.mredant.customer.phoneNumber.PhoneNumber;
import be.cm.mredant.item.Item;
import be.cm.mredant.item.ItemService;
import be.cm.mredant.order.incomingOrders.InComingOrder;
import be.cm.mredant.order.incomingOrders.ItemGroup;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Arrays;

import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceTest.Application.class)
public class OrderServiceTest {

    @Inject
    private OrderService orderService;

    @Inject
    private ItemService itemService;

    @Inject
    private CustomerService customerService;

    @Test
    public void HappyPath_IntegrationTest_addOrders_GivenACustomerAnd1Item_CreateNewOrder_ShouldReturnSumOfPrice() {
        //GIVEN
        Customer customer = Customer.CustomerBuilder.builder()
                .withFirstName("Jan")
                .withFirstName("Pietjoris")
                .withAddress(Address.of("Hutsepot", "5a", "Ghent", "9000"))
                .withEmail(Email.of("d.h@gmail.com"))
                .withPhoneNumber(PhoneNumber.of("09/123.45.56"))
                .build();

        Item item = Item.ItemBuilder.builder()
                .withItemName("HP XrV2-i5-1234")
                .withItemDescription("The slowest damn thing on the planet")
                .withPrice(500.00)
                .withItemStock(2)
                .build();

        itemService.addNewItemToDatabase(item);
        customerService.addCustomerToDatabase(customer);

        //WHEN
        Double totalPrice = orderService.addOrders(InComingOrder.builder()
                .withCustomer(customer.getCustomerId().toString())
                .withItemGroup(Arrays.asList(ItemGroup.builder()
                        .withItemId(item.getItemId().toString())
                        .withAmount(1))));
        //THEN
        Assertions.assertThat(totalPrice).isEqualTo(500);
    }

    @SpringBootApplication(scanBasePackages = {"be.cm.mredant"})
    public static class Application {

                public static void main(String[] args) {

            run(Application.class, args);
        }
    }
}

