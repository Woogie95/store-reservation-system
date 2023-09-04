package com.zerobase.storereservationsystem.dto;

import com.zerobase.storereservationsystem.domain.entity.Member;
import com.zerobase.storereservationsystem.domain.type.MemberStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginMemberResponse {

    private String email;
    private String password;
    private MemberStatus memberStatus;

    public static LoginMemberResponse from(Member member) {
        return LoginMemberResponse.builder()
                .email(member.getEmail())
                .password(member.getUsername())
                .memberStatus(member.getMemberStatus())
                .build();
    }
}
