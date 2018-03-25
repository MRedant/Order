package be.cm.mredant.item;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/item"})
public class ItemController {

    private ItemMapper itemMapper;
    private ItemService itemService;

    @Inject
    public ItemController(ItemMapper itemMapper, ItemService itemService) {
        this.itemMapper = itemMapper;
        this.itemService = itemService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem (@RequestBody ItemDto itemDto){
        return itemMapper.toDto(itemService.addNewItemToDatabase(itemMapper.toDomain(itemDto)));
    }

    @PutMapping(path = "/{itemId}", consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ItemDto updateItem (@RequestBody ItemDto newItem, @PathVariable("itemId") String itemId ){
        return itemMapper.toDto(itemService.updateItemInDatabase(itemId,itemMapper.toDomain(newItem)));
    }
}
