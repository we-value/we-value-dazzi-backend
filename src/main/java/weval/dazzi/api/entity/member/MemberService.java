package weval.dazzi.api.entity.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weval.dazzi.domain.member.Member;
import weval.dazzi.domain.member.access.repository.MemberRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member find(Long id) {
        Optional<Member> member = memberRepository.findAllById(id);
        if (member.isEmpty()) {
            throw new IllegalStateException("찾을 수 있는 멤버가 없습니다");
        }
        return member.get();
    }
}
