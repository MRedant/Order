package be.cm.mredant.item;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemService {

    private ItemRepository itemRepository;

    @Inject
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addNewItemToDatabase(Item item){
        return itemRepository.addItemToDatabase(item);
    }
}
