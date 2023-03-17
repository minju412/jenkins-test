package com.example.jenkinstest.springRestDoc.controller;

import com.example.jenkinstest.springRestDoc.dto.CreateRequest;
import com.example.jenkinstest.springRestDoc.dto.Response;
import com.example.jenkinstest.springRestDoc.dto.UpdateRequest;
import com.example.jenkinstest.springRestDoc.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    /*
     *  1. member 조회
     *  2. member 추가
     *  3. member 수정
     *  4. member 삭제
     *  5. member 전체 조회
     * */

    @GetMapping("/member/{name}")
    public Response getMember(@PathVariable String name) {
        return memberService.getMember(name);
    }

    @PostMapping("/member")
    public void createMember(@RequestBody CreateRequest request) {
        memberService.createMember(request);
    }

    @PutMapping("/member/{name}")
    public Response updateMember(@RequestBody UpdateRequest request, @PathVariable String name) {
        return memberService.updateMember(request, name);
    }

    @DeleteMapping("/member/{name}")
    public Response deleteMember(@PathVariable String name) {
        return memberService.deleteMember(name);
    }

    @GetMapping("/members")
    public List<Response> getAllMember() {
        return memberService.getAllMember();
    }

}


