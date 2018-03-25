package be.cm.mredant.item;

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

    public Item addItemToDatabase(Item item){
        return itemDatabase.addNewItem(item);
    }
}
