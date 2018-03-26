package be.cm.mredant.item;

import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class ItemMapper {

    public ItemDto toDto(Item item){
        return ItemDto.builder()
                .withItemId(item.getItemId())
                .withItemName(item.getItemName())
                .withItemDescription(item.getItemDescription())
                .withItemStock(item.getItemStock())
                .withPrice(item.getPrice());
    }

    public Item toDomain(ItemDto itemDto){
        return Item.ItemBuilder.builder()
                .withItemName(itemDto.getItemName())
                .withItemDescription(itemDto.getItemDescription())
                .withItemStock(itemDto.getItemStock())
                .withPrice(itemDto.getPrice())
                .build();
    }
}
