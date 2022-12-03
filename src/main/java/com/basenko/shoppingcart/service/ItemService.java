package com.basenko.shoppingcart.service;

import com.basenko.shoppingcart.dto.request.ItemDto;
import com.basenko.shoppingcart.model.Item;
import com.basenko.shoppingcart.repo.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository ;

    public List<Item> getAllItems (){
        return itemRepository.findAll();
    }

    public Item getById(String id) {
        return itemRepository.findById(id).get();
    }

    @Transactional
    public void saveItem(ItemDto itemDto) {
        Item item = Item.builder()
                .id(UUID.randomUUID().toString())
                .costs(itemDto.getCosts())
                .description(itemDto.getDescription())
                .name(itemDto.getName())
                .build();
        itemRepository.save(item);
    }
}
