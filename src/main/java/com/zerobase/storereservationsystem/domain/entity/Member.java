package com.zerobase.storereservationsystem.domain.entity;

import com.zerobase.storereservationsystem.domain.type.MemberStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    private String password;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    private LocalDateTime registered;

}
