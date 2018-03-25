package be.cm.mredant.item.databases;

import be.cm.mredant.exceptions.EntryAlreadyExistsInDatabaseException;
import be.cm.mredant.exceptions.UnknownResourceException;
import be.cm.mredant.item.Item;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class UnitTestItemDatabaseTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void HappyPathaddNewItem_GivenANewItem_AddToDatabase() {
        //GIVEN
        Item item = Item.ItemBuilder.builder()
                .withItemName("HP Envy")
                .withItemDescription("Super fast laptop")
                .withPrice(BigDecimal.valueOf(1234.25))
                .withItemStock(5)
                .build();

        ItemDatabase itemDatabase = new ItemDatabase();

        //WHEN
        itemDatabase.addNewItem(item);

        //THEN
        Assertions.assertThat(itemDatabase.getListDatabase().get(0)).isEqualToComparingFieldByField(item);
    }
    @Test
    public void addNewItem_GivenAnItemWhoIsAlreadyInTheList_ThrowException() {
        //GIVEN
        Item item = Item.ItemBuilder.builder()
                .withItemName("HP Envy")
                .withItemDescription("Super fast laptop")
                .withPrice(BigDecimal.valueOf(1234.25))
                .withItemStock(5)
                .build();

        ItemDatabase itemDatabase = new ItemDatabase();

        //WHEN
        itemDatabase.addNewItem(item);

        //THEN
        thrown.expect(EntryAlreadyExistsInDatabaseException.class);
        thrown.expectMessage("ItemDatabase already contains "+item.getItemName()+" "+item.getItemId().toString());
        itemDatabase.addNewItem(item);
    }

    @Test
    public void HappyPath_updateItem_GivenAnItemWhichAlreadyExists_ReturnUpdatedItem(){
        //GIVEN
        Item item = Item.ItemBuilder.builder()
                .withItemName("HP Envy")
                .withItemDescription("Super fast laptop")
                .withPrice(BigDecimal.valueOf(1234.25))
                .withItemStock(5)
                .build();

        Item updatedItem = Item.ItemBuilder.builder()
                .withItemName("HP Envy")
                .withItemDescription("Super fast laptop")
                .withPrice(BigDecimal.valueOf(2500.25))
                .withItemStock(2)
                .build();

        Item expectedItem = Item.ItemBuilder.builder()
                .withItemName("HP Envy")
                .withItemDescription("Super fast laptop")
                .withPrice(BigDecimal.valueOf(2500.25))
                .withItemStock(2)
                .build()
                .setItemId(item.getItemId().toString());


        ItemDatabase itemDatabase = new ItemDatabase();

        //WHEN
        itemDatabase.addNewItem(item);
        Item returnedItem = itemDatabase.updateItemInDatabase(item.getItemId().toString(),updatedItem);

        //THEN
        Assertions.assertThat(returnedItem).isEqualToComparingFieldByField(expectedItem);
    }
    @Test
    public void updateItem_GivenAnItemWhichIsNotInTheDatabase_ThrowException(){
        //GIVEN
        Item item = Item.ItemBuilder.builder()
                .withItemName("HP Envy")
                .withItemDescription("Super fast laptop")
                .withPrice(BigDecimal.valueOf(1234.25))
                .withItemStock(5)
                .build();

        Item updatedItem = Item.ItemBuilder.builder()
                .withItemName("HP Envy")
                .withItemDescription("Super fast laptop")
                .withPrice(BigDecimal.valueOf(2500.25))
                .withItemStock(2)
                .build();

        Item expectedItem = Item.ItemBuilder.builder()
                .withItemName("HP Envy")
                .withItemDescription("Super fast laptop")
                .withPrice(BigDecimal.valueOf(2500.25))
                .withItemStock(2)
                .build()
                .setItemId(item.getItemId().toString());


        ItemDatabase itemDatabase = new ItemDatabase();

        //WHEN
        itemDatabase.addNewItem(item);


        //THEN
        thrown.expect(UnknownResourceException.class);
        thrown.expectMessage("We could not find a Item for the provided itemId :invalid-Item-Id");
        itemDatabase.updateItemInDatabase("invalid-Item-Id",updatedItem);
    }
}