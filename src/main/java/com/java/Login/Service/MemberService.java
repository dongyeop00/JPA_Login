package com.java.Login.Service;

import com.java.Login.Dto.MemberDTO;
import com.java.Login.Entity.MemberEntity;
import com.java.Login.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        //1. dto -> entity 변환
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);

        //2. repository의 save 메서드 호출
        MemberEntity save = memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO){
        //1. 회원이 입력한 이메일로 DB에서 조회를 함
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(byMemberEmail.isPresent()){ //조회 결과 있다.
            MemberEntity memberEntity = byMemberEmail.get(); //엔티티 객체 가져오기
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){ //엔티티의 password와 DTO의 password 일치 확인
                //비밀번호 일치
                //1. entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }
            else{
                return null;
            }
        }
        else{ //조회 결과 없다.
            return null;
        }
        //2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
    }
}
