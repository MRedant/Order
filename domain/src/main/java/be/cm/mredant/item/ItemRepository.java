package be.cm.mredant.item;

import be.cm.mredant.exceptions.UnknownResourceException;
import be.cm.mredant.item.databases.ItemDatabase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemRepository {

    private ItemDatabase itemDatabase;

    @Inject
    public ItemRepository(ItemDatabase itemDatabase) {
        this.itemDatabase = itemDatabase;
    }

    public Item addItemToDatabase(Item item) {
        return itemDatabase.addNewItem(item);
    }

    public Item updateItemInDatabase(String itemId, Item newItem) {
        return itemDatabase.updateItemInDatabase(itemId, newItem);
    }

    public void removeStockForItem (String itemId, Integer amount){
        itemDatabase.removeStockForItem(itemId,amount);
    }

    public Item getItemById(String itemId) throws UnknownResourceException {
        for (Item item : itemDatabase.getListDatabase()) {
            if (item.getItemId().toString().equals(itemId)) return item;
        }
        throw new UnknownResourceException("itemId :" + itemId, "Item");
    }
}
