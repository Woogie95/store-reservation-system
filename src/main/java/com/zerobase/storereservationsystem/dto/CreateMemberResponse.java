package com.zerobase.storereservationsystem.dto;

import com.zerobase.storereservationsystem.domain.entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMemberResponse {

    private Long id;
    private String email;
    private String username;
    private String phoneNumber;

    public static CreateMemberResponse from(Member member) {
        return CreateMemberResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .username(member.getUsername())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }

}