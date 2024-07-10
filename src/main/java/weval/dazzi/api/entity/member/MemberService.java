package weval.dazzi.api.entity.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weval.dazzi.api.config.config.security.jwt.JwtTokenProvider;
import weval.dazzi.api.entity.oauth.dto.ResponseOauth;
import weval.dazzi.api.entity.member.dto.ResponseMember;
import weval.dazzi.domain.entity.member.Member;
import weval.dazzi.domain.entity.member.access.repository.MemberRepository;

import java.util.Optional;

import static weval.dazzi.domain.enums.SocialLoginType.*;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public Member checkAndSave(ResponseOauth.UserInfo userInfo) {
        Optional<Member> member = memberRepository.findBySocialId(userInfo.getId());

        if (member.isEmpty()) {
            return memberRepository.save(userInfo.toEntity(KAKAO));
        }
        return member.get();
    }

    public ResponseMember.IsSeller memberIsSeller(String token) {
        String memberId = jwtTokenProvider.getMemberId(token.substring(7));

        Optional<Member> findMember = memberRepository.findByMemberId(Long.valueOf(memberId));

        return new ResponseMember.IsSeller(findMember);
    }
}
