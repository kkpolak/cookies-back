package com.example.cookiesapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Achievement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String type;
  private String name;
  private String level;
  private String description;
}
