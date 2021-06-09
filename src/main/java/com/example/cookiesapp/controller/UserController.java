package com.example.cookiesapp.controller;

import com.example.cookiesapp.entity.User;
import com.example.cookiesapp.request.UserRequest;
import com.example.cookiesapp.service.UserService;
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
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(path = "/users")
  public List<User> getAll() {
    return userService.getAllUsers();
  }

  @PostMapping(path = "/user")
  public ResponseEntity<User> createUser(@RequestBody
      UserRequest userRequest) {
    var result = userService.createUser(userRequest);

    return ResponseEntity.ok(result);
  }
}
