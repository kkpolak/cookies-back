package com.example.cookiesapp.service;

import com.example.cookiesapp.entity.Cookie;
import com.example.cookiesapp.repository.AchievementRepository;
import com.example.cookiesapp.repository.CookieRepository;
import com.example.cookiesapp.repository.ItemRepository;
import com.example.cookiesapp.repository.UserRepository;
import com.example.cookiesapp.request.CookieRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

  @Autowired
  private CookieRepository cookieRepository;
  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AchievementRepository achievementRepository;

  public CookieService() {
  }

  public List<Cookie> getAllCookies() {
    return cookieRepository.findAll();
  }

  public Cookie createCookie(CookieRequest request) {
    Cookie c;
    var item = itemRepository.getById(request.getItemID());
    var user = userRepository.getById(request.getUserID());
    var achievements = achievementRepository
        .findAllById(request.getAchievementsIDs());
    try {
      c = cookieRepository.save(Cookie.builder()
          .achievements(achievements)
          .counter(request.getCounter())
          .item(item)
          .user(user)
          .build());

      return c;
    } catch (Exception e) {
      throw new IllegalArgumentException("item could not be created",
          e.getCause());
    }
  }

}
