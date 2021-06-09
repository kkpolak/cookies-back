package com.example.cookiesapp.request;

import java.util.List;
import lombok.Data;

@Data
public class CookieRequest {

  private int userID;
  private int counter;
  private List<Integer> achievementsIDs;
  private int itemID;
}
