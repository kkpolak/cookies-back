package com.example.cookiesapp.request;

import lombok.Data;

@Data
public class AchievementRequest {
  private String type;
  private String name;
  private String level;
  private String description;
}
