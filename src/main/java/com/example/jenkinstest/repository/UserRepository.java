package com.example.jenkinstest.repository;

import com.example.jenkinstest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
