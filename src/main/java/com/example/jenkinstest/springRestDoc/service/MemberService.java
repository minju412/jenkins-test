package com.example.jenkinstest.springRestDoc.service;

import com.example.jenkinstest.springRestDoc.dto.CreateRequest;
import com.example.jenkinstest.springRestDoc.dto.Response;
import com.example.jenkinstest.springRestDoc.dto.UpdateRequest;
import com.example.jenkinstest.springRestDoc.entity.Member;
import com.example.jenkinstest.springRestDoc.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Response getMember(String name) {
        Member member = memberRepository.findByName(name);
        log.debug("get Member : {}", member.getName());
        return new Response().fromEntity(member);
    }

    public void createMember(CreateRequest request) {
        Member member = request.toEntity();
        log.debug("create Member : {}", member.getName());
        memberRepository.save(member);
    }

    public Response updateMember(UpdateRequest request, String name) {
        Member member = memberRepository.findByName(name);
        member.setGrade(request.getGrade());
        member.setYear(request.getYear());
        memberRepository.save(member);
        log.debug("update member : {}, {}", member.getGrade(), member.getYear());
        return new Response().fromEntity(member);
    }

    public Response deleteMember(String name) {
        Member member = memberRepository.findByName(name);
        log.debug("delete member : {}", member.getName());
        memberRepository.delete(member);
        return new Response().fromEntity(member);
    }

    public List<Response> getAllMember() {
        List<Member> members = memberRepository.findAll();
        List<Response> result = new ArrayList<>();
        log.debug("list member size : {}", members.size());
        for(Member member : members){
            result.add(new Response().fromEntity(member));
        }
        return result;
    }
}

