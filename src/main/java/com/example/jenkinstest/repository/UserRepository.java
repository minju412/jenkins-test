package com.example.jenkinstest.repository;

import com.example.jenkinstest.domain.dasibom.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Long> {
}
