package com.example.cookiesapp.security;

import lombok.Data;

@Data
public class AuthenticationRequest {
  private String username;
  private String password;
}
