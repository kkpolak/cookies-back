package com.example.cookiesapp.request;

import lombok.Data;

@Data
public class ItemRequest {

  private int value;
  private String type;
  private String name;
  private String description;
  private int number;
}
