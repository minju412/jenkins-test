package com.example.jenkinstest.dasibom.service;

import com.example.jenkinstest.dasibom.domain.User;
import com.example.jenkinstest.dasibom.domain.UserSaveReqDto;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(UserSaveReqDto requestDto);

}
