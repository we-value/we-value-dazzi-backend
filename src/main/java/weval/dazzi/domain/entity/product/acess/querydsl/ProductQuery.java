package weval.dazzi.domain.entity.product.acess.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import weval.dazzi.api.entity.product.dto.QResponseProduct_ProductAllInfo;
import weval.dazzi.api.entity.product.dto.ResponseProduct;

import static weval.dazzi.domain.entity.product.QProduct.*;
import static weval.dazzi.domain.entity.seller.QSeller.*;

@Repository
@RequiredArgsConstructor
public class ProductQuery {

    private final JPAQueryFactory jpaQueryFactory;

    public ResponseProduct.ProductAllInfo findByProduct(Long productId) {
        return jpaQueryFactory
                .select(new QResponseProduct_ProductAllInfo(product.seller.sellerId, product.productId, product.title, product.price, product.description))
                .from(product, seller)
                .where(product.productId.eq(productId))
                .fetchOne();
    }
}

