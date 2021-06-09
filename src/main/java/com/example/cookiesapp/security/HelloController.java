package com.example.cookiesapp.security;

import com.example.cookiesapp.entity.User;
import com.example.cookiesapp.request.UserRequest;
import com.example.cookiesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserService userService;

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping(path = "/signin")
  public ResponseEntity<?> createAuthenticateToken(
      @RequestBody AuthenticationRequest authenticationRequest)
      throws Exception {
    try {
      authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(
              authenticationRequest.getUsername(),
              authenticationRequest.getPassword()));
    } catch (DisabledException d){
      d.printStackTrace();
      throw new Exception("USER_UNVIALABLE", d);
    } catch (BadCredentialsException e) {
      System.out.println("SIEMA EX");
      e.printStackTrace();
      throw new Exception("Incorrect username or password", e);
    }
    final UserDetails userDetails = userService
        .loadUserByUsername(authenticationRequest.getUsername());

    System.out.println(userDetails.toString());
    var jwt = jwtUtil.generateToken(userDetails);

    System.out.println(jwt);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

  @PostMapping(path = "/signup")
  public ResponseEntity<User> createUser(@RequestBody
      UserRequest userRequest) {
    var result = userService.createUser(userRequest);

    return ResponseEntity.ok(result);
  }
}
