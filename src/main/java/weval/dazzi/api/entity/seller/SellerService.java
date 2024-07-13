package weval.dazzi.api.entity.seller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weval.dazzi.api.config.config.security.jwt.JwtTokenProvider;
import weval.dazzi.api.entity.seller.dto.RequestSeller;
import weval.dazzi.api.entity.seller.dto.ResponseSeller;
import weval.dazzi.domain.entity.member.Member;
import weval.dazzi.domain.entity.member.access.repository.jpa.MemberRepository;
import weval.dazzi.domain.entity.member.access.repository.querydsl.MemberQuery;
import weval.dazzi.domain.entity.seller.access.querydsl.SellerQuery;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerService {

    private final SellerQuery sellerQuery;

    private final MemberRepository memberRepository;

    private final MemberQuery memberQuery;

    private final JwtTokenProvider jwtTokenProvider;

    public ResponseSeller.SellerAllInfo sellerInfo(String token) {
        String memberId = jwtTokenProvider.getMemberId(token.substring(7));

        return sellerQuery.findBySeller(Long.valueOf(memberId));
    }

    public ResponseSeller.SellerIdInfo createSeller(RequestSeller.CreateSeller createSeller) {
        String memberId = jwtTokenProvider.getMemberId(createSeller.getToken());
        Optional<Member> findMember = memberRepository.findByMemberId(Long.valueOf(memberId));

        Member member = findMember.orElseThrow(
            () -> new IllegalStateException("사용자를 찾을 수 없습니다.")
        );

        member.memberToMappingSeller(createSeller.toEntity());
        memberRepository.save(member);

        return new ResponseSeller.SellerIdInfo(member.getSeller().getSellerId());
    }

    public ResponseSeller.SellerIdInfo updateSeller(RequestSeller.UpdateSeller updateSeller) {
        Member member = memberQuery.findBySellerId(updateSeller.getId());

        if (member == null) {
            new IllegalStateException("판매자를 찾을 수 없습니다.");
        }

        member.getSeller().updateInfo(updateSeller.getName(), updateSeller.getIntroduction());
        return new ResponseSeller.SellerIdInfo(member.getSeller().getSellerId());
    }
}
