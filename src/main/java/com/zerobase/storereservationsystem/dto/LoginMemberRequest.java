package com.zerobase.storereservationsystem.dto;

import com.zerobase.storereservationsystem.domain.type.MemberStatus;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginMemberRequest {

    @Email(message = "이메일 형식에 맞게 입력해 주세요.")
    @NotBlank(message = "이메일은 필수 항목 입니다.")
    private String email;

    @Size(min = 4, message = "최소 4자리 이상 입력해주세요.")
    @NotBlank(message = "비밀번호는 필수 항목 입니다.")
    private String password;

    private MemberStatus memberStatus;


}
