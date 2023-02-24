package com.example.jenkinstest.springRestDoc.dto;

import com.example.jenkinstest.springRestDoc.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Response {
    private String name;
    private String grade;
    private Integer year;

    public Response fromEntity(Member member){

        this.name = member.getName();
        this.grade = member.getGrade();
        this.year = member.getYear();
        return this;
    }
}

