package com.example.jenkinstest.dasibom.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveReqDto {

    @NotNull(message = "아이디는 필수 입력 값입니다.")
    private String username;

    @NotBlank(message = "패스워드는 필수 입력 값입니다.")
    private String password;
}
