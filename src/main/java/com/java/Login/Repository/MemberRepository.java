package com.java.Login.Repository;

import com.java.Login.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회
    Optional<MemberEntity> findByMemberEmail(String memberEmail);

    //-> select * from member_table where member_email=?
}
