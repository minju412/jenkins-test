package com.example.jenkinstest.service;

import com.example.jenkinstest.domain.dasibom.Member;
import com.example.jenkinstest.domain.UserSaveReqDto;
import com.example.jenkinstest.repository.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public List<Member> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Member saveUser(UserSaveReqDto requestDto) {
        Member user = Member.createUser(requestDto.getUsername(), requestDto.getPassword());
        userRepository.save(user);
        return user;
    }
}
