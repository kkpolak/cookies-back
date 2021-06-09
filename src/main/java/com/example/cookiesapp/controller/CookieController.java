package com.example.cookiesapp.controller;

import com.example.cookiesapp.entity.Cookie;
import com.example.cookiesapp.request.CookieRequest;
import com.example.cookiesapp.service.CookieService;
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
public class CookieController {

  @Autowired
  private CookieService cookieService;

  @GetMapping(path = "/cookies")
  public List<Cookie> getAll() {
    return cookieService.getAllCookies();
  }

  @PostMapping(path = "/cookie")
  public ResponseEntity<Cookie> createCookie(@RequestBody
      CookieRequest cookieRequest) {
    var result = cookieService.createCookie(cookieRequest);

    return ResponseEntity.ok(result);
  }

}
