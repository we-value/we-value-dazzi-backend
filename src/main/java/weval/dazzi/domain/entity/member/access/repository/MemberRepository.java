package weval.dazzi.domain.entity.member.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weval.dazzi.domain.entity.member.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberId(Long id);

    Optional<Member> findBySocialId(String socialId);
}