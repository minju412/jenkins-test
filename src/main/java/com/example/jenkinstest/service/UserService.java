package com.example.jenkinstest.service;

import com.example.jenkinstest.domain.dasibom.Member;
import com.example.jenkinstest.domain.UserSaveReqDto;
import java.util.List;

public interface UserService {

    List<Member> getAllUsers();

    Member saveUser(UserSaveReqDto requestDto);

}
