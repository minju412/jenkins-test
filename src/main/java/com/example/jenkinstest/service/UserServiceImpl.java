package com.example.jenkinstest.service;

import com.example.jenkinstest.domain.User;
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User saveUser(UserSaveReqDto requestDto) {
        User user = User.createUser(requestDto.getUsername(), requestDto.getPassword());
        userRepository.save(user);
        return user;
    }
}
