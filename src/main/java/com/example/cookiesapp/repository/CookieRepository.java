package com.example.cookiesapp.repository;

import com.example.cookiesapp.entity.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends
    JpaRepository<Cookie, Integer> {

}
