package weval.dazzi.api.entity.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weval.dazzi.api.entity.oauth.dto.ResponseOauth;
import weval.dazzi.domain.enums.SocialLoginType;
import weval.dazzi.domain.member.Member;
import weval.dazzi.domain.member.access.repository.MemberRepository;

import java.util.Optional;

import static weval.dazzi.domain.enums.SocialLoginType.*;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member checkAndSave(ResponseOauth.UserInfo userInfo) {
        Optional<Member> member = memberRepository.findBySocialId(userInfo.getId());

        if (member.isEmpty()) {
            return memberRepository.save(userInfo.toEntity(KAKAO));
        }
        return member.get();
    }

    public Member find(Long id) {
        Optional<Member> member = memberRepository.findAllById(id);
        if (member.isEmpty()) {
            throw new IllegalStateException("찾을 수 있는 멤버가 없습니다");
        }
        return member.get();
    }
}
