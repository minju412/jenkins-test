package com.example.jenkinstest.dasibom.web;

import com.example.jenkinstest.dasibom.domain.Response;
import com.example.jenkinstest.dasibom.domain.UserSaveReqDto;
import com.example.jenkinstest.dasibom.domain.User;
import com.example.jenkinstest.dasibom.service.UserService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 회원 등록
    @PostMapping()
    public Response saveUser(@Valid @RequestBody UserSaveReqDto userSaveReqDto) {
        userService.saveUser(userSaveReqDto);
        return new Response("OK", "회원 등록에 성공했습니다");
    }

    // 회원 리스트 조회
    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
