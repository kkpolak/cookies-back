package com.example.cookiesapp.service;

import com.example.cookiesapp.entity.Item;
import com.example.cookiesapp.repository.ItemRepository;
import com.example.cookiesapp.request.ItemRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

  @Autowired
  private ItemRepository itemRepository;

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }

  public Item createItem(ItemRequest request) {
    Item i;
    try {
      i = itemRepository.save(Item.builder()
          .description(request.getDescription())
          .name(request.getName())
          .number(request.getNumber())
          .type(request.getType())
          .value(request.getValue())
          .build());

      return i;
    } catch (Exception e) {
      throw new IllegalArgumentException("item could not be created",
          e.getCause());
    }
  }

}
