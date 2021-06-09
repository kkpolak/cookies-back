package com.example.cookiesapp.service;

import com.example.cookiesapp.entity.Achievement;
import com.example.cookiesapp.repository.AchievementRepository;
import com.example.cookiesapp.request.AchievementRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchievementService {

  @Autowired
  private AchievementRepository achievementRepository;

  public List<Achievement> getAllAchievement() {
    return achievementRepository.findAll();
  }

  public Achievement createAchievement(AchievementRequest request) {
    Achievement a;
    try {
      a = achievementRepository.save(Achievement.builder()
          .description(request.getDescription())
          .name(request.getName())
          .type(request.getType())
          .level(request.getLevel())
          .build());

      return a;
    } catch (Exception e) {
      throw new IllegalArgumentException("item could not be created",
          e.getCause());
    }
  }
}
