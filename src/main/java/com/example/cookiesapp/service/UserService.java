package com.example.cookiesapp.service;

import com.example.cookiesapp.entity.User;
import com.example.cookiesapp.repository.UserRepository;
import com.example.cookiesapp.request.UserRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    return userRepository.findAll().stream()
        .filter(u -> u.getUsername().equals(username))
        .findAny().orElseThrow(() -> new UsernameNotFoundException(
            "user not found: " + username));
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User createUser(UserRequest request) {
    User u;
    try {
      u = userRepository.save(User.builder()
          .email(request.getEmail())
          .username(request.getUsername())
          .password(request.getPassword())
          .build());

      return u;
    } catch (Exception e) {
      throw new IllegalArgumentException("user could not be created",
          e.getCause());
    }
  }

}
