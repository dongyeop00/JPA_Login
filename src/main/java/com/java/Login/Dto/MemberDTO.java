package com.java.Login.Dto;

//lombok은 getter, setter 메서드 자동 생성
import com.java.Login.Entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor //기본 생성자 자동 생성
@AllArgsConstructor
@ToString //ToString으로 멤버 출력
public class MemberDTO { //회원 정보를 private로 저장
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        return memberDTO;
    }
}
