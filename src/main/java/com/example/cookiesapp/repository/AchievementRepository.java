package com.example.cookiesapp.repository;

import com.example.cookiesapp.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends
    JpaRepository<Achievement, Integer> {

}
