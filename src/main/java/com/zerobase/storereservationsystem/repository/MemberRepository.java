package com.zerobase.storereservationsystem.repository;

import com.zerobase.storereservationsystem.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    long countByEmail(String email);

    Optional<Member> findByEmail(String email);

}
