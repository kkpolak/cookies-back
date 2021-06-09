package com.example.cookiesapp.controller;

import com.example.cookiesapp.entity.Achievement;
import com.example.cookiesapp.request.AchievementRequest;
import com.example.cookiesapp.service.AchievementService;
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
public class AchievementController {

  @Autowired
  private AchievementService achievementService;

  @GetMapping(path = "/achievements")
  public List<Achievement> getAll() {
    return achievementService.getAllAchievement();
  }

  @PostMapping(path = "/achievement")
  public ResponseEntity<Achievement> createAchievement(@RequestBody
      AchievementRequest achievementRequest) {
    var result = achievementService
        .createAchievement(achievementRequest);

    return ResponseEntity.ok(result);
  }

}
