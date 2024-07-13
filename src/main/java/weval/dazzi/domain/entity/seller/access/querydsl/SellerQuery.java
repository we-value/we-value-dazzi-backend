package weval.dazzi.domain.entity.seller.access.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import weval.dazzi.api.entity.seller.dto.QResponseSeller_SellerAllInfo;
import weval.dazzi.api.entity.seller.dto.ResponseSeller;

import static weval.dazzi.domain.entity.member.QMember.member;
import static weval.dazzi.domain.entity.seller.QSeller.seller;

@Repository
@RequiredArgsConstructor
public class SellerQuery {

    private final JPAQueryFactory jpaQueryFactory;

    public ResponseSeller.SellerAllInfo findBySeller(Long memberId) {
        return jpaQueryFactory.select(new QResponseSeller_SellerAllInfo(
                        seller.sellerId, seller.name, seller.introduction))
                .from(member)
                .leftJoin(member.seller, seller)
                .where(member.memberId.eq(memberId))
                .fetchOne();
    }
}
