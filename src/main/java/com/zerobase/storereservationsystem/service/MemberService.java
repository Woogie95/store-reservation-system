package com.zerobase.storereservationsystem.service;

import com.zerobase.storereservationsystem.domain.entity.Member;
import com.zerobase.storereservationsystem.dto.CreateMemberRequest;
import com.zerobase.storereservationsystem.dto.CreateMemberResponse;
import com.zerobase.storereservationsystem.dto.LoginMemberRequest;
import com.zerobase.storereservationsystem.dto.LoginMemberResponse;
import com.zerobase.storereservationsystem.exception.ExistEmailException;
import com.zerobase.storereservationsystem.exception.UserNotFoundException;
import com.zerobase.storereservationsystem.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private BCryptPasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;

    public void createMember(CreateMemberRequest createMemberRequest) {
        if (memberRepository.countByEmail(createMemberRequest.getEmail()) > 0) {
            throw new ExistEmailException("이미 존재하는 이메일 입니다.");
        }

        memberRepository.save(Member.builder()
                .email(createMemberRequest.getEmail())
                .username(createMemberRequest.getUsername())
                .password(createMemberRequest.getPassword())
                .phoneNumber(createMemberRequest.getPhoneNumber())
                .memberStatus(createMemberRequest.toEntity().getMemberStatus())
                .registered(LocalDateTime.now())
                .build());
    }

    public Optional<LoginMemberRequest> login(LoginMemberRequest loginMemberRequest) {
        Optional<Member> byEmail = memberRepository.findByEmail(loginMemberRequest.getEmail());
        if (byEmail.isPresent()) {
            Member member = byEmail.get();
            if (passwordEncoder.matches(loginMemberRequest.getPassword(), member.getPassword())) {
                return Optional.of(loginMemberRequest);
            } else {
                return Optional.empty();
            }
        } else {
            throw new UserNotFoundException("해당 이메일로 등록된 회원이 없습니다.");
        }
        return LoginMemberResponse.from();
    }


}
