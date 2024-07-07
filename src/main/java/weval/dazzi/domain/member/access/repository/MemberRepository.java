package weval.dazzi.domain.member.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weval.dazzi.domain.member.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findAllById(Long id);

    Optional<Member> findBySocialId(String socialId);
}