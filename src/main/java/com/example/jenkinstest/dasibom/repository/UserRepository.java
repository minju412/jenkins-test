package com.example.jenkinstest.dasibom.repository;

import com.example.jenkinstest.dasibom.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
