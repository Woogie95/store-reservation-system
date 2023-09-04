package com.zerobase.storereservationsystem.controller;

import com.zerobase.storereservationsystem.dto.CreateMemberRequest;
import com.zerobase.storereservationsystem.dto.CreateMemberResponse;
import com.zerobase.storereservationsystem.dto.LoginMemberRequest;
import com.zerobase.storereservationsystem.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<CreateMemberResponse> createMember(@RequestBody @Valid CreateMemberRequest createMemberRequest) {
        memberService.createMember(createMemberRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginMemberRequest loginMemberRequest) {
        Optional<LoginMemberRequest> login = memberService.login(loginMemberRequest);
        if (loginResult.isPresent()) {
            return ResponseEntity.ok(loginResult.get());
        } else {
            // 로그인 실패 시 명확한 에러 메시지와 함께 HTTP 상태 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("로그인 정보가 올바르지 않습니다.");
        }
    }
}
