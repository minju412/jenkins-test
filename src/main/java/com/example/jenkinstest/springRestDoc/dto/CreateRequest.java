package com.example.jenkinstest.springRestDoc.dto;

import com.example.jenkinstest.springRestDoc.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequest {
    private String name;
    private String grade;
    private Integer year;

    public Member toEntity(){
        Member member = new Member();
        member.setName(this.name);
        member.setGrade(this.grade);
        member.setYear(this.year);
        return member;
    }
}

