package com.example.jenkinstest.service;

import com.example.jenkinstest.domain.User;
import com.example.jenkinstest.domain.UserSaveReqDto;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(UserSaveReqDto requestDto);

}
