package weval.dazzi.domain.entity.member.access.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import weval.dazzi.domain.entity.member.Member;

import static weval.dazzi.domain.entity.member.QMember.*;
import static weval.dazzi.domain.entity.seller.QSeller.*;

@Repository
@RequiredArgsConstructor
public class MemberQuery {

    private final JPAQueryFactory queryFactory;

    public Member findBySellerId(Long SellerId) {
        return queryFactory
                .selectFrom(member)
                .join(member.seller, seller).fetchJoin()
                .where(member.seller.sellerId.eq(SellerId))
                .fetchOne();

    }
}
