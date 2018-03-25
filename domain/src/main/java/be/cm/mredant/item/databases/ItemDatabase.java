package be.cm.mredant.item.databases;

import be.cm.mredant.exceptions.EntryAlreadyExistsInDatabaseException;
import be.cm.mredant.exceptions.UnknownResourceException;
import be.cm.mredant.item.Item;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class ItemDatabase {

    private List<Item> itemDatabase;

    public ItemDatabase() {
        this.itemDatabase = new ArrayList<>();
    }

    public List<Item> getListDatabase() {
        return Collections.unmodifiableList(itemDatabase);
    }

    public Item addNewItem(Item item) throws EntryAlreadyExistsInDatabaseException {
        if (itemDatabaseContainsItemWithSameDetails(item)) {
            throw new EntryAlreadyExistsInDatabaseException(item.getItemName() + " " + item.getItemId(), "ItemDatabase");
        }
        itemDatabase.add(item);
        return item;
    }

    private boolean itemDatabaseContainsItemWithSameDetails(Item item) {
        boolean contains = false;
        for (Item part : itemDatabase) {
            if (part.equals(item)) contains = true;
        }
        return contains;
    }

    public Item updateItemInDatabase(String itemId, Item newItem) throws UnknownResourceException {
        if (itemDatabaseContainsItemWithItemId(itemId)==null){
            throw new UnknownResourceException("itemId :" + itemId, "Item");
        }
        itemDatabase.set(itemDatabase.indexOf(itemDatabaseContainsItemWithItemId(itemId)),newItem.setItemId(itemId));
        return newItem;
    }

    private Item itemDatabaseContainsItemWithItemId(String itemId) {
        Item returnItem = null;
        for (Item item :itemDatabase) {
            if (item.getItemId().toString().equals(itemId)) returnItem = item;
        }
        return returnItem;
    }
}
