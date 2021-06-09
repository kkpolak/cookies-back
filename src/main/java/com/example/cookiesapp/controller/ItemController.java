package com.example.cookiesapp.controller;

import com.example.cookiesapp.entity.Item;
import com.example.cookiesapp.request.ItemRequest;
import com.example.cookiesapp.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ItemController {

  @Autowired
  private ItemService itemService;

  @GetMapping(path = "/items")
  public List<Item> getAll() {
    return itemService.getAllItems();
  }

  @PostMapping(path = "/item")
  public ResponseEntity<Item> createItem(@RequestBody
      ItemRequest itemRequest) {
    var result = itemService.createItem(itemRequest);

    return ResponseEntity.ok(result);
  }
}
